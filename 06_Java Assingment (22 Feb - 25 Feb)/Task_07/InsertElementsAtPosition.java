package Task_07;
import java.util.LinkedList;

/*
Write a Java program to insert some elements at the specified position into a linked list.
*/

public class InsertElementsAtPosition {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        colors.add(1, "Yellow");
        colors.add(2, "Purple");

        System.out.println("LinkedList after inserting elements at specified position: " + colors);
    }
}
