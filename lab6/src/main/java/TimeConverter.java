import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class TimeConverter {
    public static void main(String[] args) {
        LocalTime parse = LocalTime.parse("10:15:30");
        LocalTime localTime = LocalTime.now().plus(86400, ChronoUnit.SECONDS);
        System.out.println(localTime);
    }

    public static String parseSecondsToTime(long time){
        long minutes = time  / 60 % 60;
        String res = minutes + "";
        if (minutes < 10) res = "0" + res;

        long hours = time /  60 / 60 % 24;
        res = hours + ":" + res;
        if (hours < 10) res = "0" + res;

        long days = time /  60 / 60 / 24;
        res = days + ":" + res;
        return res;
    }

    public static Long parseTimeToLong(String string) throws MyException {
        try{
            String[] split = string.trim().split(":");
            if (split.length!=3){
                throw new MyException();
            }

            long days = Long.parseLong(split[0]);

            long hours = Long.parseLong(split[1]);
            if (hours>24 || hours <0){
                throw new MyException();
            }

            long minutes = Long.parseLong(split[2]);
            if (minutes>60 || minutes <0){
                throw new MyException();
            }

            Long result = 0L;
            result+=days*86400+hours*3600+minutes*60;
            return result;

        }
        catch (Exception e){
            throw new MyException();
        }
    }
}
