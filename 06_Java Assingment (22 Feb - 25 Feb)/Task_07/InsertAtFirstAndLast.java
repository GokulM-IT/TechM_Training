package Task_07;
import java.util.LinkedList;

/*
Write a Java program to insert elements into the linked list at the first and last positions.
*/

public class InsertAtFirstAndLast {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        colors.addFirst("Purple");
        colors.addLast("Yellow");

        System.out.println("LinkedList after inserting at first and last positions: " + colors);
    }
}
