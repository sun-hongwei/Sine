import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by sunhongwei on 2017/12/16.
 * 正弦曲线和余弦曲线
 */

public class Main extends JPanel {

    private double sinX;
    private double sinY;

    private double cosX;
    private double cosY;

    @Override
    protected void paintComponent(Graphics g) {
        final BufferedImage targetImg = new BufferedImage(1200, 300, BufferedImage.TYPE_INT_RGB);//获得一个image对象
        final Graphics g2d = targetImg.createGraphics();//获得一个图形类
        //调用两遍paintImage 方法
        // 1、在JPanel 上绘制图形
        // 2、在保存图片 上绘制保存图形
        paintImage(g2d);
        paintImage(g);
        //将画图的图形保存成图片
        saveImage(targetImg);
    }

    /**
     * 画出正弦曲线及余弦曲线
     * @param g2d
     */
    private void paintImage(Graphics g2d){
        g2d.setColor(Color.WHITE);//设置面板背景色
        g2d.fillRect(0, 0, 1200, 300);//填充面板
        g2d.setColor(Color.RED);//设置画线的颜色
        for (sinX = 0; sinX <= 1000; sinX += 0.1)//一个周期
        {
            if (sinX > 300) {
                //sin
                sinY = Math.sin(sinX * Math.PI / 180);//转化为弧度,1度=π/180弧度
                sinY = (80 + 80 * sinY);//便于在屏幕上显示
                g2d.drawLine((int) sinX, (int) sinY + 50, (int) sinX, (int) sinY + 50);//画
            }

        }
        g2d.setColor(Color.BLACK);//设置画线的颜色
        for (cosX = 0; cosX <= 1000; cosX += 0.1)//一个周期
        {
            if (cosX < 700) {
                //cos
                cosY = Math.cos(cosX * Math.PI / 180);//转化为弧度,1度=π/180弧度
                cosY = (80 + 80 * cosY);//便于在屏幕上显示
                g2d.drawLine((int) cosX + 250, (int) cosY + 50, (int) cosX + 250, (int) cosY + 50);//画点
            }
        }
    }

    /**
     * 保存图片到指定文件夹
     * @param targetImg
     */
    private void saveImage(BufferedImage targetImg){
        try {
            ImageIO.write(targetImg, "jpeg", new File("2.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Main s = new Main();
        JFrame j = new JFrame();
        j.setTitle("正弦加余弦");
        j.add(s);
        j.setSize(1300, 500);
        j.setLocation(300, 300);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
