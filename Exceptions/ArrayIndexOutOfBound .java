public class ArrayIndexOutOfBound {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int numFromNegativeIndex = nums[-1];
        int numFromGreaterIndex = nums[4];
        int numFromLengthIndex = nums[3];
    }
    // if a piece of code tries to access an illegal index of an array, the respective method throws an ArrayIndexOutOfBoundException.
}