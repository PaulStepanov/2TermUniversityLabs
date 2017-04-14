import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Первый аргумент - х
 * второй - точность
 */

public class Task2 {

    public static void main(String... args) throws Exception {
        //Читаем args
        ArrayList<String> runArgs = new ArrayList<String>(Arrays.asList(args));
        if (runArgs.size() < 2) {
            throw new Exception("Not enough args to run");
        }
        //setup variables
        Double x = Double.valueOf(runArgs.get(0));
        Double accuracy = Double.valueOf(runArgs.get(1));

        //считаем слева
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        Future<Double> funcResult = singleThreadExecutor.submit(() -> Math.cosh(x));

        //считаем справа до точности
        double sum = 0;
        boolean flag = true;
        int n = 0;
        Double prev = null;
        //Эта сложна функция суммы
        while (flag) {
            double compRes = Math.pow(x, 2 * n) / factorial(2 * n);//Считаем элемент ряда
            n++;
            sum = sum + compRes;

            if (prev != null && Math.abs(prev - compRes) < accuracy) {
                flag = false;
            }

            prev = compRes;
        }

        singleThreadExecutor.shutdown();

        //Выводим
        System.out.println(sum);
        System.out.println(funcResult.get());


    }

    /**
     * @param number double
     * @return factorial
     */
    public static double factorial(double number) {
        if (number <= 1) return 1;
        else return number * factorial(number - 1);
    }
}
