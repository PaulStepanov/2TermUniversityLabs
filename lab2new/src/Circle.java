
/**
 * Created by Павел on 01.03.2017.
 */
public class Circle {
    private Point centerPoint;

    public void showCenter() {
        StringBuilder stringBuilder=new StringBuilder();
        System.out.println(stringBuilder
                .append("X=" )
                .append(centerPoint.getX())
                .append( " Y= ")
                .append(centerPoint.getY())
        );
    }

    Circle(Point senterPoint) {
        this.centerPoint = senterPoint;
    }
}
