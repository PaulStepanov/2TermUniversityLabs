import java.util.ArrayList;

public class TrainXmlReaderTest {
    public static void main(String[] args) {
        ArrayList<Train> trains = TrainXmlReader.readFromFile("trains.xml");

        trains.forEach(System.out::println);
    }


}