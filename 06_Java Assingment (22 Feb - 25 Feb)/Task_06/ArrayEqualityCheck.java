package Task_06;
import java.util.Arrays;

/*
Write a Java program to create a generic method that takes two arrays of the same type and checks if they have the same elements in the same order.
*/

public class ArrayEqualityCheck {
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4};
        Integer[] array2 = {1, 2, 3, 4};
        
        boolean result = areArraysEqual(array1, array2);
        System.out.println("Arrays are equal: " + result);
    }

    public static <T> boolean areArraysEqual(T[] array1, T[] array2) {
        return Arrays.equals(array1, array2);
    }
}
