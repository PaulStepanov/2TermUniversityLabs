import javax.swing.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class TrainTableModel extends MyTableModel {
    private List<Train> trains = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /* передаём классу список объектов,
     * который будет отображаться в таблице */
    public TrainTableModel(List<Train> trains) {
        this.trains = trains;
    }

    /* устанавливаем количество столбцов таблицы */
    @Override
    public int getColumnCount() {
        return 7;
    }

    /* определяем заголовки столбцов */
    @Override
    public String getColumnName(int index) {
        switch (index) {
            case 0:
                return "№";
            case 1:
                return "Откуда";
            case 2:
                return "Куда";
            case 3:
                return "Отбытие";
            case 4:
                return "Прибытие";
            case 5:
                return "время пути";
            case 6:
                return "станции";
        }
        return null;
    }

    /* определяем типы данных в столбцах */
    @Override
    public Class<?> getColumnClass(int index) {
        switch (index) {
            case 0:
                return Long.class;
            case 1:
            case 2:
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Long.class;
            case 6:
                return Integer.class;
        }
        return null;
    }

    /* определяем количество строк */
    @Override
    public int getRowCount() {
        return trains.size();
    }

    /* получаем ячейку в указанной строке и столбце */
    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Train train = trains.get(rowIndex);
        switch (colIndex) {
            case 0:
                return validate(train.getId());
            case 1:
                return validate(train.getSourceStation());
            case 2:
                return validate(train.getDestinationStation());
            case 3:
                return validate(train.getFromDate() == null ? "" : train.getFromDate().format(formatter));
            case 4:
                return validate(train.getToDate() == null ? "" : train.getToDate().format(formatter));
            case 5:
                return validate(timeDifference(train));
            case 6:
                return validate(train.getStations().size());
        }
        return null;
    }


    private String timeDifference(Train train) {

        if (train.getFromDate() == null || train.getToDate() == null) {
            return "";
        }

        long fromTime = Date.from(train.getFromDate().atZone(ZoneId.systemDefault()).toInstant()).getTime();
        long toTime = Date.from(train.getToDate().atZone(ZoneId.systemDefault()).toInstant()).getTime();

        long between = toTime - fromTime;


        return TimeConverter.parseSecondsToTime(between/1000);
    }

    /* записываем ячейку в указанную строку и столбец */
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex) {
        Train train = trains.get(rowIndex);
        try {

            switch (colIndex) {
                case 1:
                    String val = ((String) value).trim();
                    if (!checkIfContainsStation(train.getStations(),val)) {
                        throw new MyException("no such station");
                    }
                    getStationByName(train.getStations(),val).setOrdinalNum(0);

                    train.setSourceStation(val);
                    break;
                case 2:
                    val = ((String) value).trim();
                    System.out.println(val);
                    if (!checkIfContainsStation(train.getStations(),val)) {
                        throw new MyException("no such station");
                    }

                    train.getStations().forEach(station -> station.setLastStation(false));
                    getStationByName(train.getStations(),val).setLastStation(true);
                    getStationByName(train.getStations(),val).setTimeToNextStationInSeconds(null);
                    train.setDestinationStation(val);
                    break;
                case 3:
                    LocalDateTime time = LocalDateTime.parse((String) value, formatter);
                    train.setFromDate(time);
                    setValueAt(timeDifference(train), rowIndex, 5);
                    break;
            }
            save();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "invalid value for field"+e.getMessage());
        }
    }

    /* определяем, можно ли редактировать
     * ячейку в указанной строке и столбце */
    @Override
    public boolean isCellEditable(int rowIndex, int colIndex) {
        return Arrays.asList(1, 2, 3).contains(colIndex);
    }

    private String validate(Object o) {
        return o == null ? "" : o.toString();
    }


}