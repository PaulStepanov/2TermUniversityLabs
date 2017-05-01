package task5.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
    private Date date;

    public MyDate(Date date) {
        this.date = date;
    }

    public MyDate(String string, SimpleDateFormat simpleDateFormat) throws ParseException {
        this.date = simpleDateFormat.parse(string);
    }
    //Set Date by formatter
    public void setDate(String string, SimpleDateFormat simpleDateFormat) throws ParseException {
        this.date = simpleDateFormat.parse(string);
    }

    public Date getDate() {
        return date;
    }

    public MyDate setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        MyDate myDate = (MyDate)obj;
        return this.date.equals(myDate.getDate());
    }
}
