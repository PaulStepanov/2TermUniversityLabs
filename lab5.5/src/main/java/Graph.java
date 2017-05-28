import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.*;

class Graph extends Canvas {

    double a;
    double b;
    double c;
    double d;
    double x1;
    double x2;
    int scalation;

    public Graph(JTextField aTextField, JTextField bTextField, JTextField cTextField, JTextField dTextField, JTextField x1TextField, JTextField x2TextField, int scalation) {
        a = Double.parseDouble(aTextField.getText());
        b = Double.parseDouble(bTextField.getText());
        c = Double.parseDouble(cTextField.getText());
        d = Double.parseDouble(dTextField.getText());
        x1 = Double.parseDouble(x1TextField.getText());
        x2 = Double.parseDouble(x2TextField.getText());
        this.scalation = scalation;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Rectangle r = g.getClipBounds();

        g.setColor(Color.BLACK);
        g.drawLine(0, r.height / 2, r.width, r.height / 2);
        g.drawLine(r.width / 2, 0, r.width / 2, r.height);

        int zeroX = r.width / 2;
        int zeroY = r.height / 2;

        int scalX = r.width / scalation;
        int scalY = r.height / scalation;

        for (Integer i = 1; i < scalation / 2; i++) {
            g.drawLine(zeroX + scalX * i, zeroY - 5, zeroX + scalX * i, zeroY + 5);
            char[] number = i.toString().toCharArray();
            g.drawChars(number,0,number.length,zeroX + scalX * i, zeroY - 10);
            g.drawLine(zeroX - scalX * i, zeroY - 5, zeroX - scalX * i, zeroY + 5);

            g.drawLine(zeroX - 5, zeroY + scalY * i, zeroX + 5, zeroY + scalY * i);
            g.drawLine(zeroX - 5, zeroY - scalY * i, zeroX + 5, zeroY - scalY * i);
        }

        g.setColor(Color.RED);
        ArrayList<Integer> xPoints = new ArrayList<>();
        ArrayList<Integer> yPoints = new ArrayList<>();
        for (double i = x1; i < x2; i += 0.0001) {
            Point p = calculateFunction(i);
            xPoints.add(zeroX + (int) (scalX * p.getX()));
            yPoints.add(r.height - (zeroY + (int) (scalY * p.getY())));
        }
        g.drawPolyline(xPoints.stream().mapToInt(x -> x).toArray(), yPoints.stream().mapToInt(y -> y).toArray(), xPoints.size());
    }

    public Graph setScalation(int scalation) {
        this.scalation = scalation;
        return this;
    }

    private Point calculateFunction(double x) {
        double funcVal = a*pow(E,1-b*pow(x,2))+c*sqrt(d*pow(x,2)+1);
        return new Point(x, funcVal);
    }
}
