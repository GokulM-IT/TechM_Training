package Task_07;
import java.util.LinkedList;

/*
Write a Java program to get the first and last occurrence of the specified elements in a linked list.
*/

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Red");

        int firstOccurrence = colors.indexOf("Red");
        int lastOccurrence = colors.lastIndexOf("Red");

        System.out.println("First occurrence of 'Red': " + firstOccurrence);
        System.out.println("Last occurrence of 'Red': " + lastOccurrence);
    }
}
