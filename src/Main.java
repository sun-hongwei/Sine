/**
 * Created by sun on 2017/12/16.
 */

import java.awt.*;
import javax.swing.*;

public class Main extends JPanel {
    private double sinX;
    private double sinY;

    private double cosX;
    private double cosY;

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.setColor(Color.WHITE);//������屳��ɫ
        g.fillRect(500, 800, 500, 500);//������
        g.setColor(Color.RED);//���û��ߵ���ɫ
        for (sinX = 0; sinX <= 2000; sinX += 0.1)//һ������
        {
            //sin
            sinY = Math.sin(sinX * Math.PI / 180);//ת��Ϊ����,1��=��/180����
            sinY = (80 + 80 * sinY);//��������Ļ����ʾ
            g.drawLine((int) sinX, (int) sinY+50, (int) sinX, (int) sinY+50);//��
        }
        g.setColor(Color.BLACK);//���û��ߵ���ɫ
        for (cosX = 0; cosX <= 2000; cosX += 0.1)//һ������
        {
            //cos
            cosY = Math.cos(cosX * Math.PI / 180);//ת��Ϊ����,1��=��/180����
            cosY = (80 + 80 * cosY);//��������Ļ����ʾ
            g.drawLine((int) cosX + 250, (int) cosY+50, (int) cosX + 250, (int) cosY+50);//����
        }
    }

    public static void main(String[] args) {
        Main s = new Main();
        JFrame j = new JFrame();
        j.setTitle("һ�����ڵ���������");
        j.add(s);
        j.setSize(500, 500);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
