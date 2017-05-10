package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Main {
    public static final String TELEPHONE_PATTERN = "((\\d{2}-))+\\d{2}-\\d{2}";

    public static void main(String... args) {
        StringBuilder inputSb = new StringBuilder(args[0]);
        Pattern pattern = Pattern.compile(TELEPHONE_PATTERN);
        Matcher matcher = pattern.matcher(inputSb);

        ArrayList<String> phoneList = new ArrayList<>();

        inputSb.append("numbers");
        while (matcher.find()) {

            phoneList.add(matcher.group());
        }

        for (int i = 0;i<phoneList.size();i++){
            inputSb.append(phoneList.get(i));
            if (i!=phoneList.size()-1){
                inputSb.append(',');
            }
        }

        System.out.println(inputSb);
    }
}
