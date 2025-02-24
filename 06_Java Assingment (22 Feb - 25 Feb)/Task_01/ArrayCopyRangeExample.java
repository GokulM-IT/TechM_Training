package Task_01;

import java.util.Arrays;

/*Use ArrayCopyRange() function to demonstrate and example such that you copy the range of values in an
array.*/

public class ArrayCopyRangeExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] copiedArray = new int[4];

        System.arraycopy(array, 2, copiedArray, 0, 4);

        System.out.println("Original Array: " + Arrays.toString(array));
        System.out.println("Copied Array (range from index 2 to 5): " + Arrays.toString(copiedArray));
    }
}
