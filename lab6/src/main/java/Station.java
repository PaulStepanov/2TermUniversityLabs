public class Station {
    private int trainId;
    private String name;
    private boolean isLastStation;
    private Integer ordinalNum;
    private Long timeToNextStationInSeconds;

    public Station(){}


    public Station(int trainId, String name, boolean isLastStation, Integer ordinalNum) {
        this.trainId = trainId;
        this.name = name;
        this.isLastStation = isLastStation;
        this.ordinalNum = ordinalNum;
    }

    public Station(int trainId, String name, boolean isLastStation, Integer ordinalNum, Long timeToNextStationInSeconds) {
        this.trainId = trainId;
        this.name = name;
        this.isLastStation = isLastStation;
        this.ordinalNum = ordinalNum;
        this.timeToNextStationInSeconds = timeToNextStationInSeconds;
    }

    public int getTrainId() {
        return trainId;
    }

    public Station setTrainId(int trainId) {
        this.trainId = trainId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Station setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isLastStation() {
        return isLastStation;
    }

    public Station setLastStation(boolean lastStation) {
        isLastStation = lastStation;
        return this;
    }

    public Integer getOrdinalNum() {
        return ordinalNum;
    }

    public Station setOrdinalNum(Integer ordinalNum) {
        this.ordinalNum = ordinalNum;
        return this;
    }


    public Long getTimeToNextStationInSeconds() {
        return timeToNextStationInSeconds;
    }

    public Station setTimeToNextStationInSeconds(Long timeToNextStationInMiliseconds) {
        this.timeToNextStationInSeconds = timeToNextStationInMiliseconds;
        return this;
    }

    @Override
    public String toString() {
        return "<station trainId=\""+trainId+"\" " +
                "name=\"" + name+"\" "+
                "isLastStation=\"" + isLastStation+"\" "+
                "ordinalNum=\"" + ordinalNum+"\" "+
                "timeToNextStationInSeconds=\"" + timeToNextStationInSeconds +"\" "+
                "></station>";
    }


}
