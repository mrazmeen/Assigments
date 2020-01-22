import java.io.*;

public class UppercaseConvert extends BufferedReader {


    public UppercaseConvert(Reader in) {
        super(in);
    }

//    @Override
//    public int read() throws IOException {
//        FileReader fileReader= new FileReader("C:\\Users\\Razmeen\\Documents\\Uppercase\\textdoc.txt");
//    int value=0;
//        while ((value=fileReader.read())!=-1){
//            System.out.println(value);
//        }
//
//        return value;
//    }

    static void fileReader() throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Razmeen\\Documents\\Uppercase\\textdoc.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int strCurrentLine = 0;
        char c;
        int dd;
        while ((strCurrentLine = bufferedReader.read()) != -1) {
            if (strCurrentLine >= 97 && strCurrentLine <= 122) {
                dd = strCurrentLine - 32;


            } else {
                dd = strCurrentLine;
            }
            c = (char) dd;
            System.out.print(c);

        }
        bufferedReader.close();
    }

    public static void main(String[] args) {
        try {
            fileReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
