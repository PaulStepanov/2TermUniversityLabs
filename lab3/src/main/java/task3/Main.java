package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String TELEPHONE_PATTERN = "((\\d{2}-))+\\d{2}-\\d{2}";

    public static void main(String... args) {
        StringBuilder inputSb = new StringBuilder(args[0]);
        Pattern pattern = Pattern.compile(TELEPHONE_PATTERN);
        Matcher matcher = pattern.matcher(inputSb);

        inputSb.append("numbers");
        while (matcher.find()) {

            inputSb.append(matcher.group());
            if (!matcher.hitEnd()) {
                inputSb.append(',');
            }
        }
        System.out.println(inputSb);
    }
}
