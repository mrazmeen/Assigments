public class NullPointerException {
    public static void main(String[] args) {
        String strObj = null;
strObj.equals("Hello World");
    }
//There are different scenarios where illegal uses of null causes NullPointerException. Let's consider some of them.
//Calling a method of the class that has no object instance:
}