package task5.logic;

import org.junit.Assert;
import org.junit.Test;
import task5.dateFormats.DateFormater;
import task5.dateFormats.constants.Countries;
import task5.domain.MyDate;

import static org.junit.Assert.assertArrayEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DateCalculatorTest {
    @Test
    public void findAverageDate() throws Exception {
        DateFormater dateFormater = new DateFormater();
        MyDate averageDate = DateCalculator.findAverageDate(
                dateFormater.parseStringToDate("12.12.2108", Countries.RUSSIA),
                dateFormater.parseStringToDate("12.12.2118", Countries.RUSSIA));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Countries.RUSSIA.getDateFormat());
        MyDate expectation = dateFormater.parseStringToDate("12.12.2113", Countries.RUSSIA);
        assertEquals(averageDate,expectation);
    }

    @Test
    public void countAmountofDatesUntilAverageDate() throws Exception {
        ArrayList<MyDate> dates = new ArrayList<>();
        DateFormater dateFormater = new DateFormater();

        dates.add(dateFormater.parseStringToDate("12.12.2112",Countries.RUSSIA));
        dates.add(dateFormater.parseStringToDate("12.09.2113",Countries.RUSSIA));
        dates.add(dateFormater.parseStringToDate("12.05.2113",Countries.RUSSIA));
        dates.add(dateFormater.parseStringToDate("12.12.2114",Countries.RUSSIA));
//        dates.add(dateFormater.parseStringToDate("12.12.2114",Countries.RUSSIA));
//        dates.add(dateFormater.parseStringToDate("12.12.2126",Countries.RUSSIA));
//        dates.add(dateFormater.parseStringToDate("12.12.2109",Countries.RUSSIA));
//        dates.add(dateFormater.parseStringToDate("12.12.2123",Countries.RUSSIA));
//        dates.add(dateFormater.parseStringToDate("12.12.2117",Countries.RUSSIA));

        System.out.println(DateCalculator.findAverageDate(dateFormater.parseStringToDate("12.12.2112",Countries.RUSSIA),dateFormater.parseStringToDate("12.12.2114",Countries.RUSSIA)).getDate().toString());
        System.out.println(DateCalculator.countAmountofDatesUntilAverageDate(dates));

        assertTrue(DateCalculator.countAmountofDatesUntilAverageDate(dates)==3);
    }

}