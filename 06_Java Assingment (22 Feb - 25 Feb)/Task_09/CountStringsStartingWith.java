package Task_09;
import java.util.Arrays;
import java.util.List;

/*
Write a Java program to count the number of strings in a list that start with a specific letter using streams.
*/

public class CountStringsStartingWith {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "apricot", "grape");

        char letter = 'a';
        long count = words.stream()
                          .filter(word -> word.startsWith(String.valueOf(letter)))
                          .count();

        System.out.println("Number of strings starting with '" + letter + "': " + count);
    }
}
