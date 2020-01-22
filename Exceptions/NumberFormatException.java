import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Razmeen
 */
public class NumberFormatException {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        NumberFormat nf = NumberFormat.getIntegerInstance();
        System.out.print("Enter a number: ");
        String input = in.nextLine();
        try {
            Number number = nf.parse(input);
            System.out.println(number);
        } catch (ParseException e) {
            System.out.println("Not a number");
            e.printStackTrace();
        }
    }
    //if we parse String instead of number it gives "java.text.ParseException"
    
}