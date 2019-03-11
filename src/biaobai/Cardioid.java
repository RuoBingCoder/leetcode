package biaobai;

import javax.swing.*;
import java.awt.*;

/**
 * @author : 石建雷
 * @date :2018/11/30
 */

public class Cardioid extends JFrame {

    //��ȡ��Ļ��С
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private static int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Cardioid(){
        super("I love you");//���ô��ڱ���
        this.setBackground(Color.BLACK);
        this.setLocation((WINDOW_WIDTH-WIDTH)/2,(WINDOW_HEIGHT-HEIGHT)/2);//���ô���λ��
        this.setSize(WIDTH, HEIGHT);//���ô��ڴ�С
        this.setLayout(getLayout());//���ô��ڲ���
        this.setVisible(true);//���ô��ڿɼ�
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//���ô���Ĭ�Ϲرշ�ʽ
    }

    public void paint(Graphics g){
        double x,y,r;//���������Լ��뾶
        Image image = this.createImage(WIDTH, HEIGHT);
        Graphics pic = image.getGraphics();
        for (int i = -2; i < 90; i++) {
            for (int j = -2; j < 90; j++) {
                r=Math.PI/45+Math.PI/45*i*(1-Math.sin(Math.PI/45*j))*18;
                x=r*Math.cos(Math.PI/45*j)*Math.sin(Math.PI/45*i)+WIDTH/2;
                y=-r*Math.sin(Math.PI/45*j)+HEIGHT/3;
                pic.setColor(Color.MAGENTA);
                pic.fillOval((int)x, (int)y, 2, 2);
            }
            g.drawImage(image,0,0,this);//����ͼƬ
        }
    }


    public static void main(String[] args) {
        new Cardioid();
    }


}
