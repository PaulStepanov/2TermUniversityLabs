package view;

import domain.ArrayService;
import exeptions.ExitInputSignal;

import java.util.Scanner;
import java.util.stream.IntStream;

import static view.Constants.*;

public class ConsoleHandler {
    private ArrayService arrayService = new ArrayService();
    private Scanner sysScanner = new Scanner(System.in);

    public void renderMenu() {
        System.out.println("1. заполнение массива случайным образом" +
                "(при этом пользователь с клавиатуры вводит количество элементов массива)");
        System.out.println("2. ввод элементов массива с клавиатуры" +
                "(при этом пользователь сначала вводит количестве элементов массива с клавиатуры," +
                " затем значения самих элементов массива)");
        System.out.println("3. вывод элементов массива на экран" +
                "в строку");
        System.out.println("4. обработка массива" +
                "см. свой вариант, часть А");
        System.out.println("5. изменение массива" +
                "см. свой вариант, часть Б");
        System.out.println("6. выход из программы");
    }

    public void processUserInput(int menuNumber) throws ExitInputSignal {
        switch (menuNumber) {
            case RANDOM: {
                System.out.println("Enter amount of random generated values");
                int amount = sysScanner.nextInt();
                arrayService.fillRandomNumbers(amount);
                System.out.println("Array was filled with "+amount+" numbers");
                break;
            }

            case INPUT_FORM_KEYBOARD: {
                System.out.println("Enter amount of numbers to add");
                int amount = sysScanner.nextInt();

                System.out.println("Enter numbers:");

                IntStream.range(0, amount).forEach(value -> {
                    String userInput = sysScanner.next();


                    try {
                        //If user inputed simple number
                        arrayService.addElement(Double.valueOf(Integer.valueOf(userInput)));
                    } catch (NumberFormatException e) {
                        arrayService.addElement(Double.valueOf(userInput));
                    }

                });
                System.out.println(amount+" numbers were added to List");
                break;
            }

            case SHOW_ARRAY: {
                if (arrayService.getActualNumList().isEmpty()){
                    System.out.println("List is empty");
                }
                arrayService.getActualNumList().forEach(System.out::println);
                break;
            }

            case PROCESS: {
                System.out.println("произведение элементов массива от начала до\n" +
                        "    // последнего элемента, удовлетворяющего условию: косинус этого числа есть число положительное:");
                System.out.println(arrayService.processList());
                break;
            }

            case CHANGE: {
                arrayService.changeList();
                System.out.println("List's been changed");
                break;
            }

            case EXIT: {
                throw new ExitInputSignal();
            }

        }
    }
}
