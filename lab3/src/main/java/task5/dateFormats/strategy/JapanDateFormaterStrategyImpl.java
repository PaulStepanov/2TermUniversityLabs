package task5.dateFormats.strategy;

import task5.dateFormats.constants.Countries;
import task5.domain.MyDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JapanDateFormaterStrategyImpl implements DateFormaterStrategy{
    private SimpleDateFormat dateFormat = new SimpleDateFormat(Countries.JAPAN.getDateFormat());


    @Override
    public MyDate parseStringToDate(String string) throws ParseException {
        return new MyDate(string,dateFormat);
    }
}
