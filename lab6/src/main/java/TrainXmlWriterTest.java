import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;



public class TrainXmlWriterTest {

    public static void main(String[] args) throws IOException, MyException {
        ArrayList<Train> trains = new ArrayList<>();

        Train train = new Train();

        train.setId(1);
        train.setSourceStation("a");
        train.setDestinationStation("b");
        train.setWayTime((long) 45454545);
        LocalDateTime now = LocalDateTime.now();
        train.setFromDate(now);
        train.setToDate(now.plusDays(1));

        Station station1 = new Station();
        station1.setTrainId(1);
        station1.setName("a");
        station1.setTimeToNextStationInSeconds(new Long(86400000));
        station1.setOrdinalNum(0);
        station1.setLastStation(false);

        Station station2 = new Station();
        station2.setTrainId(1);
        station2.setName("c");
        station2.setTimeToNextStationInSeconds(null);
        station2.setOrdinalNum(1);
        station2.setLastStation(true);

        train.getStations().add(station1);
        train.getStations().add(station2);

        trains.add(train);

        TrainXmlWriter.getInstance().writeToFile(trains);


    }

}