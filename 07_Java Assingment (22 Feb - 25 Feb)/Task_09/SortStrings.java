package Task_09;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
*/

public class SortStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        List<String> sortedAsc = words.stream()
                                      .sorted()
                                      .collect(Collectors.toList());

        System.out.println("Sorted in ascending order: " + sortedAsc);

        List<String> sortedDesc = words.stream()
                                       .sorted((w1, w2) -> w2.compareTo(w1))
                                       .collect(Collectors.toList());

        System.out.println("Sorted in descending order: " + sortedDesc);
    }
}
