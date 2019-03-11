package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @Authur: 石建雷
 * @Date:2018/12/29
 */

public class Theme extends JFrame {
    private JFrame jf1;
    private JPanel jp1;
    private JButton jb1, jb2;
    private DefaultTableModel model;
    private JTable jt1;


    public Theme() {
        String[][] datas = {{"张三","1222"},{"李四","345656"}};
        String[] title = {"列一", "列二"};
        model = new DefaultTableModel(datas, title);
        jt1 = new JTable(model);
        jp1 = new JPanel();
        jp1.add(jt1, BorderLayout.NORTH);


        jf1 = new JFrame();
        jf1.add(jp1);
        jf1.setSize(400, 300);
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf1.setVisible(true);
    }

    public static void main(String[] args) {
        new Theme();
    }
}
