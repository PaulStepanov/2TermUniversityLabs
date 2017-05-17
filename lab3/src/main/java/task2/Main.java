package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;


public class Main {
    public static void main(String... args) {
        ArrayList<String> runArgs = new ArrayList<String>(Arrays.asList(args));
        System.out.println("Inputted array");
        printList(runArgs);
        String subString = "k";
        //12.	По позиции первого вхождения заданной подстроки S в строку
        runArgs.sort(comparing(s -> s.indexOf(subString)));
        System.out.println("first sort");
        printList(runArgs);
        //По части строки, расположенной между первым вхождением заданной
        // подстроки S1 и последним вхождением заданной подстроки S2.
        runArgs.sort(comparing(s -> {
            if (s.indexOf(subString)==s.lastIndexOf(subString))
                return "";
            return s.substring(
                    s.indexOf(subString) + subString.length(),//strart substing
                    s.lastIndexOf(subString));//end sbstr
        }
        ));
        System.out.println("second sort");
        printList(runArgs);
    }


     static void printList(List list) {
        list.forEach(System.out::println);
    }

}
