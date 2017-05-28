

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class Picture extends Canvas {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Rectangle r = g.getClipBounds();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(r.x+50, r.y+50, r.width-100, r.height-100);
        g.setColor(Color.BLACK);
        g.fillOval(r.x+25, r.y+25, r.width-50, r.height-50);
        g.setColor(Color.WHITE);
        g.fillOval(r.x+30, r.y+30, r.width-60, r.height-60);



        g.setColor(Color.BLUE);
        g.fillRect(r.x+80, r.y+80, r.width-160, r.height-160);
        g.setColor(Color.BLUE);
        g.fillOval(r.x+55, r.y+55, r.width-110, r.height-110);
        g.setColor(Color.CYAN);
        g.fillOval(r.x+60, r.y+60, r.width-120, r.height-120);

        g.setColor(Color.BLACK);
        g.fillOval(r.x+120, r.y+120, r.width-240, r.height-240);

        g.setColor(Color.YELLOW);
        g.fillPolygon(new int[]{0, r.width-40, r.width-30}, new int[]{0, r.height-30, r.height-40}, 3);

    }
}

class Form extends JFrame {
    public Form() {
        super("Логотип");
        setBounds(100, 50, 380, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Picture picture = new Picture();
        add(picture);

        validate();
        setVisible(true);


    }


}

public class Main {
    public static void main(String[] args) {
        new Form();
    }
}
