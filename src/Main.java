import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by sunhongwei on 2017/12/16.
 * �������ߺ���������
 */

public class Main extends JPanel {

    private double sinX;
    private double sinY;

    private double cosX;
    private double cosY;

    @Override
    protected void paintComponent(Graphics g) {
        final BufferedImage targetImg = new BufferedImage(1200, 300, BufferedImage.TYPE_INT_RGB);//���һ��image����
        final Graphics g2d = targetImg.createGraphics();//���һ��ͼ����
        // TODO Auto-generated method stub
        super.paintComponent(g);
        paintImage(g2d);
        paintImage(g);
        //����ͼ��ͼ�α����ͼƬ
        saveImage(targetImg);
    }

    /**
     * �����������߼���������
     * @param g2d
     */
    private void paintImage(Graphics g2d){
        g2d.setColor(Color.WHITE);//������屳��ɫ
        g2d.fillRect(0, 0, 1200, 300);//������
        g2d.setColor(Color.RED);//���û��ߵ���ɫ
        for (sinX = 0; sinX <= 1000; sinX += 0.1)//һ������
        {
            if (sinX > 300) {
                //sin
                sinY = Math.sin(sinX * Math.PI / 180);//ת��Ϊ����,1��=��/180����
                sinY = (80 + 80 * sinY);//��������Ļ����ʾ
                g2d.drawLine((int) sinX, (int) sinY + 50, (int) sinX, (int) sinY + 50);//��
            }

        }
        g2d.setColor(Color.BLACK);//���û��ߵ���ɫ
        for (cosX = 0; cosX <= 1000; cosX += 0.1)//һ������
        {
            if (cosX < 700) {
                //cos
                cosY = Math.cos(cosX * Math.PI / 180);//ת��Ϊ����,1��=��/180����
                cosY = (80 + 80 * cosY);//��������Ļ����ʾ
                g2d.drawLine((int) cosX + 250, (int) cosY + 50, (int) cosX + 250, (int) cosY + 50);//����
            }
        }
    }

    /**
     * ����ͼƬ��ָ���ļ���
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
        j.setTitle("���Ҽ�����");
        j.add(s);
        j.setSize(1300, 500);
        j.setLocation(300, 300);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
