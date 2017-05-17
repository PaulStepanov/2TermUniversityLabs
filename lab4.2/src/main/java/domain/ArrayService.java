package domain;

import logic.NumberHandler;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayService {
    private ArrayList<Double> actualNumList = new ArrayList<Double>();

    //1.	заполнение массива случайным образом
    // (при этом пользователь с клавиатуры вводит количество элементов массива)
    public void fillRandomNumbers(int amountOfNumbers) {
        if (amountOfNumbers < 0) {
            throw new RuntimeException("Negative amount of generated numbers, given :" + amountOfNumbers);
        }

        Random rand = new Random();

        IntStream.range(0, amountOfNumbers).forEach(value ->
                actualNumList.add(rand.nextDouble())
        );
    }

    public void addElement(Double element){
        actualNumList.add(element);
    }

    public ArrayList<Double> getActualNumList(){
        return (ArrayList<Double>) actualNumList.clone();
    }


    //12.	произведение элементов массива от начала до
    // последнего элемента, удовлетворяющего условию: косинус этого числа есть число положительное
    public Double processList(){
        return actualNumList.stream().reduce(1d,(accum, aDouble) -> {
            if (Math.cos(aDouble)>0)
                accum*=aDouble;
            return accum;
        });
    }

    //Удалите из массива все элементы, модуль целой части которых —
    //12.	это число, которое при перестановке его цифр в обратном порядке не изменяется;
    public void changeList(){
        actualNumList = actualNumList.stream()
                .filter(value -> {
                    NumberHandler<Double> doubleNumberHandler = new NumberHandler<>();
                    return doubleNumberHandler.isPalindrome(value);
                })
                .collect(Collectors.toCollection(ArrayList<Double>::new));
    }
}
