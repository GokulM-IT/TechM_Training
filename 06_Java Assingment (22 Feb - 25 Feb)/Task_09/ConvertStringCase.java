package Task_09;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Write a Java program to convert a list of strings to uppercase or lowercase using streams.
*/

public class ConvertStringCase {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        List<String> upperCaseWords = words.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());

        System.out.println("Uppercase: " + upperCaseWords);

        List<String> lowerCaseWords = words.stream()
                                           .map(String::toLowerCase)
                                           .collect(Collectors.toList());

        System.out.println("Lowercase: " + lowerCaseWords);
    }
}
