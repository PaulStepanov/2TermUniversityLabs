package by.zarabon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solve {
    public void solution() throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Point a = new Point(Double.parseDouble(reader.readLine()), Double.parseDouble(reader.readLine()));
        Point b = new Point(Double.parseDouble(reader.readLine()), Double.parseDouble(reader.readLine()));
        Point c = new Point(Double.parseDouble(reader.readLine()), Double.parseDouble(reader.readLine()));
        Point d = new Point(Double.parseDouble(reader.readLine()), Double.parseDouble(reader.readLine()));
        Triangle t = new Triangle(a, b, c);

        Triangle t1 = new Triangle(a, b, d);
        Triangle t2 = new Triangle(a, d, c);
        Triangle t3 = new Triangle(d, b, c);

        if(t.square() == t1.square() + t2.square() + t3.square()){
            System.out.println("Точка лежит внутри треугольника");
        } else System.out.println("Точка не лежит внутри треугольника");
    }
}
