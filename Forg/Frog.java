public class Frog {

    public static void main(String args[]) {
        double val = 0;
        int distance = 50;
        int count = 0;
        int rest = 8;
        double bvalue = 0;

        for (int i = 0; i < distance; i++) {
            val = distance - 9;
            distance = (int) val;

//            System.out.println(val);

            count++;
        }

        if (val != 5) {
            bvalue = 1 / 5 * val;
            //System.out.println(bvalue);
        } else if (val == 5) {
            bvalue = 1;
        }

        double finalval = rest * count + bvalue;
        System.out.println(finalval);

    }
}
