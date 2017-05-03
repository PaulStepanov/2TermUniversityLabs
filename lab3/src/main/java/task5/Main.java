package task5;

import task5.dateFormats.DateFormater;
import task5.dateFormats.constants.Countries;
import task5.domain.MyDate;
import task5.logic.DateCalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {
        ArrayList<MyDate> dates = new ArrayList<>();
        DateFormater dateFormater = new DateFormater();

        String userCounty = args[0];
        Countries country = Countries.valueOf(userCounty);
        for (int i=1;i<args.length;i++) {
            dates.add(dateFormater.parseStringToDate(args[i],country));
        }


        System.out.println("result:"+DateCalculator.countAmountofDatesUntilAverageDate(dates));
    }
}
