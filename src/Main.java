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
        g.setColor(Color.WHITE);//设置面板背景色
        g.fillRect(0, 0, 1200, 300);//填充面板
        g.setColor(Color.RED);//设置画线的颜色
        for (sinX = 0; sinX <= 1000; sinX += 0.1)//一个周期
        {
            if(sinX > 300){
                //sin
                sinY = Math.sin(sinX * Math.PI / 180);//转化为弧度,1度=π/180弧度
                sinY = (80 + 80 * sinY);//便于在屏幕上显示
                g.drawLine((int) sinX, (int) sinY+50, (int) sinX, (int) sinY+50);//画
            }

        }
        g.setColor(Color.BLACK);//设置画线的颜色
        for (cosX = 0; cosX <= 1000; cosX += 0.1)//一个周期
        {
            if(cosX < 700){
                //cos
                cosY = Math.cos(cosX * Math.PI / 180);//转化为弧度,1度=π/180弧度
                cosY = (80 + 80 * cosY);//便于在屏幕上显示
                g.drawLine((int) cosX + 250, (int) cosY+50, (int) cosX + 250, (int) cosY+50);//画点
            }
        }
    }

    public static void main(String[] args) {
        Main s = new Main();
        JFrame j = new JFrame();
        j.setTitle("正弦加余弦");
        j.add(s);
        j.setSize(1300, 500);
        j.setLocation(300,300);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
