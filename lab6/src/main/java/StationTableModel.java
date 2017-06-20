import javax.swing.*;
import java.util.Arrays;

public class StationTableModel extends MyTableModel {
    private Train train;

    public StationTableModel(Train train) {
        this.train = train;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int index) {
        switch(index) {
            case 0: return "поезд";
            case 1: return "название";
            case 2: return "последняя";
            case 3: return "номер";
            case 4: return "время до след";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int index) {
        switch(index) {
            case 0: return Long.class;
            case 1: return String.class;
            case 2: return Boolean.class;
            case 3: return Integer.class;
            case 4: return Long.class;
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return train==null?0:train.getStations().size();
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        if(train==null){
            return "";
        }
        Station station = train.getStations().get(rowIndex);
        switch(colIndex) {
            case 0: return station.getTrainId();
            case 1: return station.getName();
            case 2: return station.isLastStation();
            case 3: return station.getOrdinalNum();
            case 4: return station.getTimeToNextStationInSeconds();
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex) {
        if(train==null){
            return;
        }
        Station station = train.getStations().get(rowIndex);
        try {
            switch (colIndex) {
                case 1:
                    String val = ((String) value).trim();

                    if (checkIfContainsStation(train.getStations(),val)){
                        throw new MyException("Station with same name is already exist");
                    }

                    //if source station is changing
                    if (train.getSourceStation()!=null && train.getSourceStation().equals(station.getName())){
                        train.setSourceStation(val);
                    }
                    //if dest station is changing
                    if (train.getSourceStation()!=null && train.getDestinationStation().equals(station.getName())){
                        train.setDestinationStation(val);
                    }

                    station.setName(val);
                    break;
                case 2:
                    station.setLastStation((Boolean) value);
                    break;
                case 3:
                    station.setOrdinalNum((Integer) value);
                    break;
                case 4:
                    station.setTimeToNextStationInSeconds((Long) value);
                    break;
            }
            save();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"invalid value "+e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int colIndex) {
        return Arrays.asList(1,3,4).contains(colIndex);
    }

    public Train getTrain() {
        return train;
    }
}