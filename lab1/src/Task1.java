import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Task1 {
    public static void main(String... args) throws Exception {
        ArrayList<String> runArgs = new ArrayList<String>(Arrays.asList(args));
        if (runArgs.size() < 3) {
            throw new Exception("Not enough args to run");
        }
        Collections.reverse(runArgs);
        System.out.println(
                runArgs.stream()
                        .map(Double::parseDouble)
                        .reduce(0d, (sum, elem) ->
                                1 / (sum + elem)
                        ));
    }
}
