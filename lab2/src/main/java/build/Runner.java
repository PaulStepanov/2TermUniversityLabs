package build;

import domain.Line;
import domain.Point;
import domain.Segment;


public class Runner {
    public static void main(String[] args) {
        /* получение координат точек из аргументов командной
         * строки */
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        /* создание точек на основе координат */
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        System.out.println("Даны две точки: " + point1
                + " и " + point2);
        /* создание отрезка, проходящего через две точки */
        Segment segment = new Segment(point1, point2);
        System.out.println("Расстояние между точками: "
                + segment.length());
        /* создание серединного перпендикуляра к отрезку */
        Line line = new Line(segment);
        System.out.print("Уравнение серединного ");
        System.out.print("перпендикуляра к отрезку, ");
        System.out.print("проходящему через данные точки: ");
        System.out.println(line);
    }
}
