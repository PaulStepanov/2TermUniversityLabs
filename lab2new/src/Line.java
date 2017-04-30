/**
 * Created by Павел on 04.03.2017.
 */
class Line {
    private Point _beginPoint;
    private Point _endPoint;
    private Point _middlePoint;

    //private Point _middlePoint;
    Line(Point beginPoint, Point endPoint) {
        _beginPoint = beginPoint;
        _endPoint = endPoint;
    }

    Point findMiddlePoint() {
        double middleX = (_beginPoint.getX() + _endPoint.getY()) / 2;
        double middleY = (_beginPoint.getY() + _endPoint.getY()) / 2;
        //System.out.println("middleX= " +middleX+ "middleY= " +middleY);
        _middlePoint = new Point(middleX, middleY);
        return _middlePoint;
    }

    private Double getAngularCoefficient() {
        return (_endPoint.getY() - _beginPoint.getY()) / (_endPoint.getX() - _beginPoint.getX());
    }

    double getAngularCoefficiendPerpendicular() {
        return 1 / ((-1) * getAngularCoefficient());
    }

    double getB() {
        _middlePoint = findMiddlePoint();
       return _middlePoint.getX() - getAngularCoefficiendPerpendicular() * _middlePoint.getY();
    }

    double getHalfLength() {
        return Math.hypot(_middlePoint.getX() - _beginPoint.getX(), _middlePoint.getY() - _endPoint.getY());
    }

}
