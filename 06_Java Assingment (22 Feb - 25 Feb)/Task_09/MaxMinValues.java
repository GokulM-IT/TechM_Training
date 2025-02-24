package Task_09;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/*
Write a Java program to find the maximum and minimum values in a list of integers using streams.
*/

public class MaxMinValues {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        OptionalInt max = numbers.stream()
                                 .mapToInt(Integer::intValue)
                                 .max();

        OptionalInt min = numbers.stream()
                                 .mapToInt(Integer::intValue)
                                 .min();

        if (max.isPresent() && min.isPresent()) {
            System.out.println("Maximum value: " + max.getAsInt());
            System.out.println("Minimum value: " + min.getAsInt());
        } else {
            System.out.println("List is empty.");
        }
    }
}
