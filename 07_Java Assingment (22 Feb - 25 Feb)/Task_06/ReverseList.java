package Task_06;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/*
Write a Java program to create a generic method that takes a list of any type and returns it as a new list with the elements in reverse order.
*/

public class ReverseList {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "cherry", "date");
        List<String> reversedList = reverseList(list);
        System.out.println("Reversed List: " + reversedList);
    }

    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        return reversed;
    }
}
