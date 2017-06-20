import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TrainXmlReader {
    public static ArrayList<Train> readFromFile(String fileName) {
        ArrayList<Train> trains = new ArrayList<>();
        try {
            InputStream stream = new FileInputStream(fileName);
            /* создаём объект для чтения XML-файла
             * (через специальный класс XMLInputFactory) */
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(stream);
            Train train = null;
            int elementType;
            String tagName;
            /* читаем из XML-документа элементы до тех пор,
             * пока документ не закончится */
            while (reader.hasNext()) {
                /* получаем тип прочитанного элемента */
                elementType = reader.next();
                switch (elementType) {
                    /* если был прочитан открывающий тег */
                    case XMLStreamReader.START_ELEMENT: {
                        /* читаем имя тега */
                        tagName = reader.getLocalName();
                        switch (tagName) {
                            case "train":
                                train = new Train();
                                /* получаем значение атрибута текущего тега
                                 * по имени атрибута */
                                String id = reader.getAttributeValue(null, "id");
                                train.setId(Integer.parseInt(id));
                                break;
                            case "sourceStation":
                                String elementText = reader.getElementText();
                                if (elementText == null || elementText.trim().equals("") || elementText.trim().equals("null")) {
                                    break;
                                }
                                /* получаем текстовое содержимое элемента */
                                train.setSourceStation(elementText);
                                break;
                            case "destinationStation":
                                elementText = reader.getElementText();
                                if (elementText == null || elementText.trim().equals("") || elementText.trim().equals("null")) {
                                    break;
                                }
                                /* получаем текстовое содержимое элемента */
                                train.setDestinationStation(elementText);
                                break;
                            case "wayTime":
                                elementText = reader.getElementText();
                                if (elementText == null || elementText.trim().equals("") || elementText.trim().equals("null")) {
                                    break;
                                }
                                /* получаем текстовое содержимое элемента */
                                train.setWayTime(Long.valueOf(elementText));
                                break;
                            case "fromDate":
                                /* получаем текстовое содержимое элемента */
                                elementText = reader.getElementText();
                                if (elementText == null || elementText.trim().equals("") || elementText.trim().equals("null")) {
                                    break;
                                }
                                train.setFromDate(parseTime(elementText));
                                break;
                            case "toDate":
                                /* получаем текстовое содержимое элемента */
                                elementText = reader.getElementText();
                                if (elementText == null || elementText.trim().equals("") || elementText.trim().equals("null")) {
                                    break;
                                }
                                train.setToDate(parseTime(elementText));
                                break;
                            case "station":
                                train.getStations().add(readStation(reader));
                                break;
                        }
                        break;
                    }
                    /* если был прочитан закрывающий тег */
                    case XMLStreamReader.END_ELEMENT: {
                        /* читаем имя тега */
                        tagName = reader.getLocalName();
                        switch (tagName) {
                            case "train":
                                trains.add(train);
                                break;
                        }
                        break;
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException | XMLStreamException e) {
        }
        return trains;
    }

    private static Station readStation(XMLStreamReader reader) {
        String trainId = reader.getAttributeValue(null, "trainId");
        String name = reader.getAttributeValue(null, "name");
        String isLastStation = reader.getAttributeValue(null, "isLastStation");
        String ordinalNum = reader.getAttributeValue(null, "ordinalNum");
        String timeToNextStationInSeconds = reader.getAttributeValue(null, "timeToNextStationInSeconds");

        Station station = new Station();
        station.setTrainId(Integer.parseInt(trainId));
        station.setName(name);
        station.setLastStation(Boolean.valueOf(isLastStation));
        station.setOrdinalNum(Integer.valueOf(ordinalNum));
        station.setLastStation(Boolean.valueOf(isLastStation));
        System.out.println(timeToNextStationInSeconds);
        station.setTimeToNextStationInSeconds(timeToNextStationInSeconds.equals("null") ? null : Long.valueOf(timeToNextStationInSeconds));

        return station;
    }

    private static LocalDateTime parseTime(String val) {
        if (val.equals("")) return null;
        return LocalDateTime.parse(val, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}