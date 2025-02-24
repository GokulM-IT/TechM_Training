package Task_07;
import java.util.LinkedList;

/*
Write a Java program to insert the specified element at the specified position in the linked list.
*/

public class InsertAtPositionLinkedList {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        colors.add(1, "Yellow");

        System.out.println("LinkedList after inserting at position: " + colors);
    }
}
