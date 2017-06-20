public class TrainXmlWriter extends EntityXmlWriter {

    public static TrainXmlWriter getInstance(){
        if(instance==null){
            instance = new TrainXmlWriter();
        }
        return instance;
    }

    private TrainXmlWriter(){
        this("trains.xml", "trains");
    }

    protected TrainXmlWriter(String filename, String entityListName){
        super(filename, entityListName);
    }

    private static TrainXmlWriter instance;
}