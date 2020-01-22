import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Razmeen
 */
public class UnparseableDate {
    
    public static void main(String[] args) {

        DateFormat format = new SimpleDateFormat("MM, dd, yyyy");

        try {
            format.parse("01, , 2010");
        } catch (ParseException e) {
            System.err.println("ParseException caught!");
            e.printStackTrace();
        }
    }
    //it returns java text pass exeption
    
}