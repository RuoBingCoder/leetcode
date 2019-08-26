package chat.client;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;

public class BeatBoxFinal2 extends JFrame{
	
	private JTextPane msgReceiver;
    private Document document;
    private JTextField textSender;
    private JButton[] buttons;
    private PrintWriter cout;
    private Socket socket;
 
	
	
	
	JButton sendBt;
	
	JTextField inputField;
	JList incomingList;
	int nextNum;
	Vector<String> listVector = new Vector<String>();
	String userName;
	ObjectOutputStream out;
	ObjectInputStream in;
	HashMap<String, boolean[]> otherSeqsMap = new HashMap<String, boolean[]>();
	public static void main(String[] args) {
		new BeatBoxFinal2().startUp("chengjiaqi");
	}

	public void startUp(String name) {
		userName = name;
		// open connection to server
		try {
			Socket sock = new Socket("127.0.0.1", 4242);
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			Thread remote = new Thread(new RemoteReader());
			remote.start();
		} catch (Exception ex) {
			System.out.println("couldn't connect - you'll have to play alone.");
		}
		buildGui();
	}

	
	public void buildGui() {
		incomingList = new JList();
		incomingList.setBackground(Color.lightGray);
		incomingList.addListSelectionListener(new MyListSelectionListener());   //��������
		incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane theList = new JScrollPane(incomingList);
		/*JPanel inputPanel = new JPanel();
		inputField = new JTextField(20);
		sendBt = new JButton("Send");
		//Ϊ��ť����¼�
		sendBt.addActionListener(new MySendListener0());
		Label lable = new Label("chat Message");  
		inputPanel.add(lable);
		inputPanel.add(inputField);
		inputPanel.add(sendBt);*/
		JToolBar toolBar = new JToolBar();
        getContentPane().add(toolBar, "South");
        textSender = new JTextField(30);
        toolBar.add(textSender);
        String[] buttonStr = {"发送文字", "发送图片"};
        buttons = new JButton[buttonStr.length];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonStr[i]);
            toolBar.add(buttons[i]);
            if(i == 0)
            	buttons[i].addActionListener(new MySendListener0());
            if(i == 1)
        	   buttons[i].addActionListener(new MySendListener1());
        }
        setVisible(true);
    	//�����������ӵ�JFrame�Ĵ���
		this.add(theList,BorderLayout.CENTER);
		//this.add(inputPanel, BorderLayout.SOUTH);
		this.add(toolBar, BorderLayout.SOUTH);
		this.setTitle("Chat Room");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
	}
	
	private String openSelectDialog() {
        String path = "";
        JFileChooser jfc = new JFileChooser(new File("."));
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int status = jfc.showOpenDialog(this);
        if (status != JFileChooser.APPROVE_OPTION) {
            //û��ѡ���ļ�
        } else {
            try {
                File file = jfc.getSelectedFile();
                path = file.getAbsolutePath().toString();
                return path;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }
 
    public void insert(String str) {
//        Document doc = msgReceiver.getDocument();
        SimpleAttributeSet attrSet = new SimpleAttributeSet();
        StyleConstants.setForeground(attrSet, Color.BLACK);
        str = "\n" + str;
        try {
            document.insertString(document.getLength(), str, attrSet);
        } catch (BadLocationException e) {
            System.out.println("BadLocationException: " + e);
        }
    }
 
    public class MySendListener1 implements ActionListener {
    	@Override
		public void actionPerformed(ActionEvent e) {
    		boolean[] checkboxState = new boolean[256];
            String path = openSelectDialog();
            //cout.println("������һ��ͼƬ");
            //insert("�ҷ�����һ��ͼƬ");
            File file = new File(path);
            /*int b = (int) file.length();//���ͼƬ��С
            byte[] bt=new byte[b];//��ʼ��һ��ͼƬ��С��byte����
            RandomAccessFile raf = new RandomAccessFile(path,"r");
            raf.read(bt);//��ͼƬ����byte���顣��Ȼ����Խ�ͼƬ�ĺ�׺��������Ҳд��byte�����У��⽫�����Ժ���ڲ���
            raf.close();*/
            
            ImageIcon image = new ImageIcon(file.getAbsolutePath().toString());
            //����ͼƬ��С
            image.setImage(image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
            msgReceiver.setCaretPosition(document.getLength());
            msgReceiver.insertIcon(image);
            insert("\n");                             
    	}
    }
	
	
	
	public class MySendListener0 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent a) {
			boolean[] checkboxState = new boolean[256];
			String messageToSend = null;
			try {
				out.writeObject(userName + nextNum + ": " + textSender.getText());
				out.writeObject(checkboxState);
			} catch (Exception ex) {
				System.out.println("Sorry dude. Could not send it to the server.");
			}
			textSender.setText("");
		}
	}

	public class MyListSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent le) {
			// TODO Auto-generated method stub
			if (!le.getValueIsAdjusting()) {
				String selected = (String) incomingList.getSelectedValue();
				if (selected != null) {
					boolean[] selectedState = (boolean[]) otherSeqsMap.get(selected);
				}
			}
		}
	}

	public class RemoteReader implements Runnable {
		boolean[] checkboxState = null;
		String nameToShow = null;
		Object obj = null;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while ((obj = in.readObject()) != null) {
					System.out.println("got an object from server");
					System.out.println(obj.getClass());
					String nameToShow = (String) obj;
					checkboxState = (boolean[]) in.readObject();
					otherSeqsMap.put(nameToShow, checkboxState);
					listVector.add(nameToShow);
					incomingList.setListData(listVector);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}