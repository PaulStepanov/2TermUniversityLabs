package com.kimreik.third;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class Picture extends Canvas {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        Rectangle r = g.getClipBounds();
//        g.setColor(Color.BLACK);
//        g.fillRect(r.x+50, r.y+50, r.width-100, r.height-100);
//        g.setColor(Color.BLACK);
//        g.fillOval(r.x+25, r.y+25, r.width-50, r.height-50);
//        g.setColor(Color.WHITE);
//        g.fillOval(r.x+30, r.y+30, r.width-60, r.height-60);
//
//        g.setColor(Color.BLACK);
//        g.fillRect(r.x+65, r.y+65, r.width-130, r.height-130);
//        g.setColor(Color.BLACK);
//        g.fillOval(r.x+40, r.y+40, r.width-80, r.height-80);
//        g.setColor(Color.WHITE);
//        g.fillOval(r.x+45, r.y+45, r.width-90, r.height-90);
//
//        g.setColor(Color.BLACK);
//        g.fillRect(r.x+80, r.y+80, r.width-160, r.height-160);
//        g.setColor(Color.BLACK);
//        g.fillOval(r.x+55, r.y+55, r.width-110, r.height-110);
//        g.setColor(Color.WHITE);
//        g.fillOval(r.x+60, r.y+60, r.width-120, r.height-120);
//
//        g.setColor(Color.BLACK);
//        g.fillOval(r.x+120, r.y+120, r.width-240, r.height-240);
//
//        g.setColor(Color.RED);
//        g.fillPolygon(new int[]{r.width-50, r.width-40, r.width-30}, new int[]{r.height-50, r.height-30, r.height-40}, 3);
    }
}

class Form extends JFrame {
    public Form() {
        super("Логотип");
        setBounds(100, 50, 380, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Picture picture = new Picture();
        add(picture);
        Runnable thread = () -> {
            while(true){
                int x1 = new Random().nextInt(picture.getWidth());
                int y1 = new Random().nextInt(picture.getHeight());
                drawDrop(picture, x1, y1);
                int sleepTime = new Random().nextInt(1000);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        validate();
        setVisible(true);
        thread.run();
        new Thread(thread).run();
        new Thread(thread).run();
    }

    private void drawDrop(Picture picture, int x, int y) {
        Runnable thread = () -> {
            Graphics g = picture.getGraphics();

            int size = 10 + new Random().nextInt(25);
            for(int i = 30; i<=200; i+=10){
                try {
                    Thread.sleep(10);
                    g.setColor(new Color(i,i,200));
                    g.fillOval(x-size/2,y-size/2,size,size);
                    size+=10;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        thread.run();
    }
}

public class Main {
    public static void main(String[] args) {
        new Form();
    }
}
