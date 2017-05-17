package domain.controller;

import domain.Student;
import domain.logic.DataHandler;

import java.util.ArrayList;

import static domain.controller.Constants.*;

public class ConsoleController {
    private DataHandler dataHandler = new DataHandler();

    public void printMenu(){
        System.out.println("1. Список студентов");
        System.out.println("2. Список на зачисление");
        System.out.println("3. Добавить студента");
        System.out.println("4. Удалить студента");
    }

    public void processUserInput(int menuNumber) {
        switch (menuNumber){
            case STUDENT_LIST:{

                break;
            }
        }
    }
}
