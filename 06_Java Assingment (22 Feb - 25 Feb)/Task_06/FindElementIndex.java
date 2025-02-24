package Task_06;
import java.util.List;

/*
Write a Java program to create a generic method that takes a list of any type and a target element. It returns the index of the first occurrence of the target element in the list. Return -1 if the target element cannot be found.
*/

public class FindElementIndex {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "cherry", "date");
        int index = findIndexOfElement(list, "cherry");
        System.out.println("Index of target element: " + index);
    }

    public static <T> int findIndexOfElement(List<T> list, T target) {
        return list.indexOf(target);
    }
}

