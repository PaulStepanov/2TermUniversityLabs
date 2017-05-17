package by.zarabon;

public class Triangle{
    private Point a, b, c;
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double square(){

//http://e-maxx.ru/algo/oriented_area
        return ((a.getX()-c.getX())*(b.getY()-c.getY())-
                (b.getX()-c.getX())*(a.getY()-c.getY()))*0.5;
    }
}
