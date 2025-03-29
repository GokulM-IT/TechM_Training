package Task_07;
import java.util.LinkedList;

/*
Write a Java program to append the specified element to the end of a linked list.
*/

public class AppendToLinkedList {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        colors.add("Yellow");

        System.out.println("LinkedList after appending: " + colors);
    }
}
