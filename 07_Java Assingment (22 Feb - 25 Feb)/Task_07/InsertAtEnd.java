package Task_07;
import java.util.LinkedList;

/*
Write a Java program to insert the specified element at the end of a linked list.
*/

public class InsertAtEnd {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        colors.addLast("Yellow");

        System.out.println("LinkedList after inserting at end: " + colors);
    }
}
