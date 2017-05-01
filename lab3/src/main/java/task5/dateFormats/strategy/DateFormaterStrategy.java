package task5.dateFormats.strategy;

import task5.dateFormats.constants.Countries;
import task5.domain.MyDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.EnumMap;

public interface DateFormaterStrategy {
    public  MyDate parseStringToDate(String string,SimpleDateFormat simpleDateFormat) throws ParseException;
}
