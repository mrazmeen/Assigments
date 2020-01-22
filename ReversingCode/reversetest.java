public class ReverseTest {

    public int  reverse(int number){

        int val=0;

        while (number!=0){
            int units=number%10;
            val=val*10+units;
            number=number/10;
        }
        return val;
    }

    public void main(){
        int a=7215468;
        int rev;
        rev=reverse(a);
        System.out.println(rev);

    }

    public static void main(String[] args) {
        ReverseTest rt= new ReverseTest();
        rt.main();
    }
}