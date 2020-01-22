import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Razmeen
 */
public class FileNotFoundException {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        new FileReader(new File("/invalid/file/location"));
    }
    //If we parse invalid file location it gives File Not Found Exception
}