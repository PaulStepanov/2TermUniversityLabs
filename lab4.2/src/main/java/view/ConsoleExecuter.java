package view;

import exeptions.ExitInputSignal;

import java.util.Scanner;

/**
 * Created by pili on 5/11/17.
 */
public class ConsoleExecuter {
    private ConsoleHandler consoleHandler = new ConsoleHandler();
    private Scanner sysScanner = new Scanner(System.in);

    public void execute() {
        consoleHandler.renderMenu();
        System.out.println("Enter menu number from 1 to 6:");
        while (true) {
            try {
                int userInput = sysScanner.nextInt();
                if (userInput < 1 || userInput > 6) {
                    System.out.println("wrong menu number ");
                    continue;
                }
                consoleHandler.processUserInput(userInput);
            } catch (ExitInputSignal exitInputSignal) {
                break;
            }
        }
        System.out.println("Exited by user");

    }
}
