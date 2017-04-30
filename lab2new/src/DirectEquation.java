/**
 * Created by Павел on 04.03.2017.
 */
/**
 * This awesome class do y=kx+b
 * */
public class DirectEquation {
    private double _k;
    private double _b;

    DirectEquation(double a, double b) {
        _k = a;
        _b = b;
    }

    public double getK() {
        return _k;
    }

    public double getB() {
        return _b;
    }
}
