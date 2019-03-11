package gui_add;

import com.sun.deploy.util.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class User_interface {

    private static JButton jbn1;
    private static JPanel panel1;
    private static JPanel panel2;

    private static TextArea textArea1;

    private static TextField textField;

    public static void Menu() {
        System.out.println("      ----------------------欢迎登录世界杯查询系统-------------------");
        System.out.println();
        System.out.println("--------------搜索菜单-----------                     ");
        System.out.println();
        System.out.println("          1.按时间查询                ");
        System.out.println();
        System.out.println("          2.按场次查询                ");
        System.out.println();
        System.out.println("          3.写评论                     ");
        System.out.println();
        System.out.println("          4.退出查询系统            ");
        System.out.println();
        System.out.println("请选择您需要的服务：1、2、3、4");
    }

    public static void main(String[] args) {
        User_interface User_interface = new User_interface();
        User_interface.initNum();

    }

    public static void initFrame(JFrame frame, int width, int height) {
        //获取默认系统软件包
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //获取屏幕的分辨率
        Dimension d = toolkit.getScreenSize();
        int x = (int) d.getWidth();
        int y = (int) d.getHeight();
        frame.setBounds((x - width) / 2, (y - height) / 2, width, height);
        frame.setVisible(true);
    }

    public static void initNum() {
        JFrame frame = new JFrame("世界杯查询系统");
        initFrame(frame, 500, 400);
        frame.setLayout(new BorderLayout());
        //设置一个面板1，添加一个搜索框和一个按钮,位于北部
        panel1 = new JPanel();

        jbn1 = new JButton("搜索");
        jbn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String str= StringUtils.join(Player.Topscorer(textField.getText()),"\n ");   //列表转String
                textArea1.setText(str);





            }
        });


        textField = new TextField(10);
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        panel1.setPreferredSize(new Dimension(100, 70));
        panel1.add(new JLabel("请输入场次:"));
        panel1.add(textField);
        panel1.add(jbn1);
        frame.add(panel1, BorderLayout.NORTH);

        //设置一个面板2，位于中部
        panel2 = new JPanel();
        textArea1 = new TextArea(15, 50);

        //JScrollPane jslp = new JScrollPane(text); //加滚动条
        //jslp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel2.add(textArea1);

        frame.add(panel2, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置关闭
        frame.setVisible(true); //窗口可见
    }
}

	/*public static void initPanel(JFrame frame) {
		//设置面板
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(100,70));
		//设置面板
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(100,50));
		//设置面板
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(100,260));
		//创建一个标签
		JLabel label1 = new JLabel("<html><font size=7 color = red>世 界 杯 查 询 系 统</font></html>",SwingConstants.CENTER);
		panel1.add(label1);
		//创建按钮
		JButton button1 = new JButton("时间");
		JButton button2 = new JButton("场次");
		panel2.add(button1);
		panel2.add(button2);
		//创建文本区域
		//让面板使用边框布局管理器
		frame.setLayout (new BorderLayout());
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel2,BorderLayout.CENTER);
		frame.add(panel3, BorderLayout.SOUTH);
	}

	public static void initPanel3(JFrame frame,JPanel panel) {
		frame.add(panel);
		panel.setLayout (new BorderLayout());
		//设置一个面板1，添加两个按钮,位于北部
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(100,30));
		JButton button1 = new JButton("6月");
		JButton button2 = new JButton("7月");
		panel1.add(button1);
		panel1.add(button2);
		panel.add(panel1,BorderLayout.NORTH);
		//创建一个面板2，并且设置为网格布局，位于中部
		JPanel panel2 = new JPanel();
		panel.add(panel2,BorderLayout.CENTER);
		//面板2设置为网格布局
		panel2.setLayout(new GridLayout(18,25));
		for(int i = 13; i <= 30;i++) {
			for(int j = 0;j < 25;j++) {
				if(i == 13 && j == 0) {
					JButton button = new JButton("D\\T");
					panel2.add(button);
				}else if(i == 13) {
					JButton button = new JButton(""+j+"");
					panel2.add(button);
				}else if(j == 0){
					JButton button = new JButton(""+i+"");
					panel2.add(button);
				}else {
					JButton button = new JButton();
					panel2.add(button);
				}
			}
		}
		//创建一个面板3，并且设置为网格布局，位于西部
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(30,50));
		panel.add(panel3,BorderLayout.EAST);
		//创建一个面板4，并且设置为网格布局，位于南部
		JPanel panel4 = new JPanel();
		panel3.setPreferredSize(new Dimension(50,30));
		panel.add(panel4,BorderLayout.SOUTH);
	}*/


