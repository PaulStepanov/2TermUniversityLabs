import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;


public abstract class MyTableModel implements TableModel {
    protected ActionListener saveListener;

    public ActionListener getSaveListener() {
        return saveListener;
    }

    public void setSaveListener(ActionListener saveListener) {
        this.saveListener = saveListener;
    }

    protected void save(){
        saveListener.actionPerformed(new ActionEvent(ActionEvent.ACTION_FIRST, 1,"1"));
    }



    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public boolean checkIfContainsStation(List<Station> stations, String stantionName) throws MyException{
        AtomicBoolean containts = new AtomicBoolean(false);
        stations.forEach(station -> {
            if (station.getName().equals(stantionName))
                containts.set(true);
        });

        return containts.get();
    }

    public Station getStationByName(List<Station> stations, String stantionName){
        return  stations.stream().filter(station -> station.getName().equals(stantionName)).collect(Collectors.toCollection(ArrayList::new)).get(0);
    }
}
