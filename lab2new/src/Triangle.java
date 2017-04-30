public class Triangle{
    private Point a, b, c;
    public Triangle(Point _a, Point _b, Point _c) {
        this.a = _a;
        this.b = _b;
        this.c = _c;
    }

    public double square(){
        return ((a.getX()-c.getX())*(b.getY()-c.getY())-
                (b.getX()-c.getX())*(a.getY()-c.getY()))*0.5;
    }
}
