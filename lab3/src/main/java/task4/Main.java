package task4;

import by.vsu.mf.ai.ssd.strings.Manager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String TELEPHONE_PATTERN = "((\\d{2}-))+\\d{2}-\\d{2}";
    public static void main(String[] args) {
        Manager.createWindow(stringBuilder -> {
            Pattern pattern = Pattern.compile(TELEPHONE_PATTERN);
            Matcher matcher = pattern.matcher(stringBuilder);

            stringBuilder.append("numbers");
            while (matcher.find()) {
                stringBuilder.append(matcher.group());
                if (!matcher.hitEnd()) {
                    stringBuilder.append(',');
                }
            }
        });
    }
}
