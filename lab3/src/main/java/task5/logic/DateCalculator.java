package task5.logic;

import task5.domain.MyDate;

import java.util.*;

public class DateCalculator {
    //finding average date between to dates using milliseconds
    public static MyDate findAverageDate(MyDate firstDate, MyDate secondDate) {
     long differedInMilliseconds = Math.abs(firstDate.getDate().getTime() - secondDate.getDate().getTime());
        //Minor date from 2 params
        Date minDate = Arrays.asList(new Date[]{firstDate.getDate(), secondDate.getDate()}).stream().min(Date::compareTo).get();

        return new MyDate(new Date(minDate.getTime()+differedInMilliseconds/2));
    }

    //Определить количество дат до даты,
    // которая является серединой временного отрезка между минимальной и максимальной из перечисленных дат
    public static  int countAmountofDatesUntilAverageDate(List<MyDate> dateList){
        dateList.sort(Comparator.comparing(MyDate::getDate));
        MyDate averageDate = findAverageDate(
                dateList.get(0), dateList.get(dateList.size()-1));//

        return dateList.stream().reduce(0, (integer, myDate) -> {
            if (myDate.getDate().compareTo(averageDate.getDate())==-1){
                return integer+1;
            }
            return integer;
        },(integer, integer2) -> integer2);
    }
}
