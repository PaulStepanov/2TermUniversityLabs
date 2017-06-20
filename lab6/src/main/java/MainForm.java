import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainForm {
    static ArrayList<Train> trains;
    static JTable trainTable;
    static JTable stationTable;

    public static void main(String[] args) {
        JComboBox<String> comboBox = new JComboBox<>();

        JFrame trainsWindow = new JFrame("поезда");
        trainsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        trainsWindow.setBounds(100, 100, 800, 600);

        trains = TrainXmlReader.readFromFile("trains.xml");
        TrainTableModel trainModel = getNewTrainModel();
        trainTable = new JTable(trainModel);
        JScrollPane scrollPane = new JScrollPane(trainTable);
        trainsWindow.add(scrollPane, BorderLayout.CENTER);

        JPanel trainButtons = new JPanel();

        JButton addTrainButton
                = new JButton("добавить поезд");
        trainButtons.add(addTrainButton);
        addTrainButton.addActionListener(e -> {
            Train train = new Train(trains.get(trains.size()-1).getId()+1);
            trains.add(train);
            comboBox.addItem(train.getId()+"");
            refreshTables();
        });

        JButton deleteTrainButton
                = new JButton("удалить");
        deleteTrainButton.addActionListener(e -> {
            int selectedId = trainTable.getSelectedRow();
            long id = Long.parseLong((String) trainTable.getValueAt(selectedId, 0));
            trains = new ArrayList<>(trains.stream().filter(train -> train.getId()!=id).collect(Collectors.toList()));
            comboBox.removeItem(id+"");
            refreshTables();
        });
        trainButtons.add(deleteTrainButton);
        trainsWindow.add(trainButtons, BorderLayout.SOUTH);

        trainsWindow.setVisible(true);
        trainsWindow.validate();



        JFrame stationWindow =  new JFrame("станции");
        stationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stationWindow.setBounds(900, 100, 800, 600);

        trains.forEach(t -> comboBox.addItem(t.getId()+""));

        stationWindow.add(comboBox, BorderLayout.NORTH);

        StationTableModel stationModel = getNewStationModel(trains.stream().filter(train -> train.getId()==Long.parseLong((String)comboBox.getSelectedItem())).findFirst().orElse(null));

        stationTable = new JTable(stationModel);

        comboBox.addActionListener(e -> stationTable.setModel(getNewStationModel(trains.stream().filter(train -> train.getId()==Long.parseLong((String)comboBox.getSelectedItem())).findFirst().orElse(null))));

        JScrollPane stationScrollPane = new JScrollPane(stationTable);
        stationWindow.add(stationScrollPane, BorderLayout.CENTER);

        JPanel buttons = new JPanel();

        JButton addStationButton
                = new JButton("добавить станцию");
        buttons.add(addStationButton);
        addStationButton.addActionListener(e -> {
            Train train = ((StationTableModel) stationTable.getModel()).getTrain();
            Station station = new Station();
            station.setTrainId((int) train.getId());
            station.setName("Init name");
            station.setOrdinalNum(-1);
            train.getStations().add(station);
            refreshTables();
        });

        JButton deleteStationButton
                = new JButton("удалить");
        deleteStationButton.addActionListener(e -> {
            Train train = ((StationTableModel) stationTable.getModel()).getTrain();
            int selectedId = stationTable.getSelectedRow();
            String stationName = (String) stationTable.getValueAt(selectedId, 1);
            train.setStations(new ArrayList<>(train.getStations().stream().filter(station -> !station.getName().equals(stationName)).collect(Collectors.toList())));
            refreshTables();
        });
        buttons.add(deleteStationButton);
        stationWindow.add(buttons, BorderLayout.SOUTH);

        stationWindow.setVisible(true);
        stationWindow.validate();
    }

    private static void save(){
        try {
            TrainXmlWriter.getInstance().writeToFile(trains);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static TrainTableModel getNewTrainModel(){
        TrainTableModel result = new TrainTableModel(trains);
        result.setSaveListener(e -> refreshTables());
        return result;
    }

    private static StationTableModel getNewStationModel(Train train){
        StationTableModel result = new StationTableModel(train);
        result.setSaveListener(e -> refreshTables());
        return result;
    }

    private static void refreshTables(){
        stationTable.setModel(getNewStationModel(((StationTableModel) stationTable.getModel()).getTrain()));
        trainTable.setModel(getNewTrainModel());
        save();
    }
    
}
