

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Train {
    private long id;
    private String sourceStation;
    private String destinationStation;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private List<Station> stations = new ArrayList<>();
    private Long wayTime;


    public Train() {
    }

    public Long getWayTime() {
        return wayTime;
    }

    public Train setWayTime(Long wayTime) {
        this.wayTime = wayTime;
        return this;
    }

    public Train(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Train setId(long id) {
        this.id = id;
        return this;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public Train setSourceStation(String sourceStation){

        this.sourceStation = sourceStation;
        return this;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public Train setDestinationStation(String destinationStation) {

        this.destinationStation = destinationStation;
        return this;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public Train setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
        countDestDate();
        return this;
    }

    public LocalDateTime getToDate() {
        countDestDate();
        return toDate;
    }

    public Train setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
        return this;
    }

    public List<Station> getStations() {
        return stations;
    }

    public Train setStations(List<Station> stations) {
        this.stations = stations;
        return this;
    }

    public LocalDateTime countDestDate() {
        if (fromDate == null) {
            return null;
        }
        Long wayTimeInSeconds = this.getStations().stream().reduce(0L, (aDouble, station) -> {
                    if (station.getOrdinalNum()==null || station.getOrdinalNum()==-1){
                        return aDouble;
                    }
                    Long timeToNextStationInSeconds = station.getTimeToNextStationInSeconds() == null ? 0 : station.getTimeToNextStationInSeconds();
                    return aDouble + timeToNextStationInSeconds;
                }, (aDouble, aDouble2) -> aDouble);
        toDate = this.getFromDate().plusSeconds(wayTimeInSeconds);
        return this.getFromDate().plusSeconds(wayTimeInSeconds);
    }


    @Override
    public String toString() {
        return "<train id=\"" + id + "\">" +
                "<sourceStation>" + sourceStation + "</sourceStation>" +
                "<destinationStation>" + destinationStation + "</destinationStation>" +
                "<wayTime>" + wayTime + "</wayTime>" +
                "<fromDate>" + (fromDate == null ? "" : fromDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))) + "</fromDate>" +
                "<toDate>" + (toDate == null ? "" : toDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))) + "</toDate>" +
                stations.stream().map(Object::toString).collect(Collectors.joining()) +
                "</train>";
    }
}
