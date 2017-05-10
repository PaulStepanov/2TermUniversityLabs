package task5.dateFormats;

import task5.dateFormats.constants.Countries;
import task5.dateFormats.strategy.DateFormaterStrategy;
import task5.dateFormats.strategy.DenmarkDateFormaterStrategyImpl;
import task5.dateFormats.strategy.JapanDateFormaterStrategyImpl;
import task5.dateFormats.strategy.RussiaDateFormaterStrategyImpl;
import task5.domain.MyDate;

import java.text.ParseException;

public class DateFormater {
    private DateFormaterStrategy strategy;

    public MyDate parseStringToDate(String string, Countries country) throws ParseException {
        setupStrategy(country);
        return strategy.parseStringToDate(string);
    }

    private void setupStrategy(Countries country){
        switch (country){
            case DENMARK:
                strategy = new DenmarkDateFormaterStrategyImpl();
                break;
            case JAPAN:
                strategy = new JapanDateFormaterStrategyImpl();
                break;
            case RUSSIA:
                strategy = new RussiaDateFormaterStrategyImpl();

        }
    }
}
