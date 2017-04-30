import by.vsu.mf.ai.ssd.painting.Painter;

/**
 * Created by pili on 4/14/17.
 */
public class Task5 {

    public static void main(String args[]) {
        double constFi = Double.parseDouble(args[0]);
        int stepsAmount = (int) (Math.PI * 2 / constFi);//расчет шагов по шагам, угол на которую постоянно увелииеваем
        double fi = constFi;//текущий угол
        double[][][] coords = new double[stepsAmount + 1][2][2];

        //Считаем координаты
        for (int i = 0; i < stepsAmount; i++) {
            double r1 = fi/(4*3.14);//функция 1
            double r2 = ((1 + Math.pow(Math.sin(fi),2)) / 2);//функция 2

            //координаты начала
            coords[i][0][0] = convertXFromPolarToCartesian(r1, fi);
            coords[i][0][1] = convertYFromPolarToCartesian(r1, fi);

            //координаты конца
            coords[i][1][0] = convertXFromPolarToCartesian(r2, fi);
            coords[i][1][1] = convertYFromPolarToCartesian(r2, fi);

            //увеилчивае угол
            fi += constFi;
        }

        //setup color
        short intensityStep = 5;
        short currentIntensity = 0;
        int colorComponent = 0;
        short[][] colors = new short[(int) stepsAmount + 1][3];
        for (int i = 0; i < stepsAmount; i++) {
            colors[i][colorComponent] = currentIntensity += intensityStep;
            if (currentIntensity == 300) {
                colorComponent++;
                currentIntensity = 0;
            }
            if (colorComponent == 3) {
                colorComponent = 0;
            }

        }
        Painter.paint(860, 640, coords, colors);
    }
    /**
     * переводит координату из полярной в декартовую
     * @param  r = радиус
     * @param  fi = угол
     * @return  координату в декартовой
     * */
    static double convertXFromPolarToCartesian(double r, double fi) {
        return r * Math.cos(fi);
    }

    static double convertYFromPolarToCartesian(double r, double fi) {
        return r * Math.sin(fi);
    }
}
