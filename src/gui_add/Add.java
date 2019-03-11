package gui_add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Add extends JFrame {
   
    private static JFrame Jframe;
    private static JPanel JPanel;
    private static JTextField JTextField1;
    private static JTextField JTextField2;
    private static JTextField JTextField3;

    private static JLabel JLabel1;
    private static JLabel JLabel2;
    private static JLabel JLabel3;

    private static JButton jbutton;

    public Add() {


        JPanel = new JPanel();
        JLabel1 = new JLabel("num1:");
        JLabel2 = new JLabel("num2:");
        JLabel3 = new JLabel("result:");
        JTextField1 = new JTextField(10);
        JTextField2 = new JTextField(10);
        JTextField3 = new JTextField(10);

        jbutton = new JButton("sum:");
        JPanel.add(JLabel1);
        JPanel.add(JTextField1);
        JPanel.add(JLabel2);
        JPanel.add(JTextField2);
        JPanel.add(jbutton);
        JPanel.add(JLabel3);
        JPanel.add(JTextField3);
        this.add(JPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
                //�����¼�
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField3.setText(String.valueOf(add()));  //��ӡ����̨

            }
        });


    }

    public int add() {
        String a = JTextField1.getText();
        String b = JTextField2.getText();

        int a1 = Integer.parseInt(a);

        int b1 = Integer.parseInt(b);

        return a1 + b1;

    }

    public static void main(String[] args) {
        Add Add = new Add();

    }
}
