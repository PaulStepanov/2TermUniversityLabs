/**
 * Created by Павел on 03.03.2017.
 */
class CircleBuilder {
    private Point _lineCenter;
    private Point _centerPoint;
    private Line _line;
    private DirectEquation _perpendicular;
    private double _radius;
    private Point _errorPoint = new Point(-1000, -1000);

    CircleBuilder(DirectEquation directEquation, double radius, Line line) {
        _perpendicular = directEquation;
        _radius = radius;
        _lineCenter = line.findMiddlePoint();
        _line = line;
    }

    Point buildCircle(int fieldDimensionsX) {
        boolean haveCenter = findCenter(fieldDimensionsX);
        if (haveCenter) {
            return _centerPoint;
        }
        System.out.print("Do not have center");
        return _errorPoint;

    }

    private boolean findCenter(int fieldDimensionsX) {
        /*if(fieldDimensionsX<0){
            System.out.print("fieldDimensionsX must be greater than 0");
            return false;
        }
        Random random=new Random();
        int randY=random.nextInt(10);
        System.out.println("randY = "+randY);
        for(int i=-fieldDimensionsX;i<fieldDimensionsX;i++){
            if(randY==(int)perpendicular.getK()*i+perpendicular.getB() && i!=0){
                _centerPoint=new Point(i,randY);
                return  true;
            }
        }*/
        if (fieldDimensionsX < 0) {
            System.out.print("fieldDimensionsX must be greater than 0");
            return false;
        }
        for (int y = -fieldDimensionsX; y < fieldDimensionsX; y++) {
            for (int x = -fieldDimensionsX; x < fieldDimensionsX; x++) {
                if (y == x * _perpendicular.getK() + _perpendicular.getB()) {
                    double perpendLenght = Math.hypot(x - _lineCenter.getX(), y - _lineCenter.getY());
                    if (_radius == Math.hypot(_line.getHalfLength(), perpendLenght)) {
                        _centerPoint = new Point(x, y);
                        return true;
                    }
                }
                //System.out.println("Не подходят точки "+x + "and " +y);
            }

        }

        return false;
    }

}
