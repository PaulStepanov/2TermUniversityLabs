import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Collection;

public abstract class EntityXmlWriter {

    private String filename;
    private String entityListName;

    protected EntityXmlWriter(String filename, String entityListName) {
        this.filename = filename;
        this.entityListName = entityListName;
    }

    public void writeToFile(Collection entities) throws IOException {

        OutputStream os = new FileOutputStream(filename);
        os.write(("<"+entityListName+">").getBytes(Charset.forName("UTF-8")));
        for (Object entity : entities) {
            os.write(entity.toString().getBytes(Charset.forName("UTF-8")));
        }
        os.write(("</"+entityListName+">").getBytes(Charset.forName("UTF-8")));
        os.close();
    }
}