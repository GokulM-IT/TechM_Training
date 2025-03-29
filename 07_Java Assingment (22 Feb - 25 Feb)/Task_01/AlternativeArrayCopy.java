package Task_01;
import java.util.Arrays;

// Write a Java program to copy the alternative elements in the array.

public class AlternativeArrayCopy {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int size = (nums.length + 1) / 2;
        int[] copiedArray = new int[size];

        for (int i = 0, j = 0; i < nums.length; i += 2, j++) {
            copiedArray[j] = nums[i];
        }

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Copied Array with alternative elements: " + Arrays.toString(copiedArray));
    }
}
