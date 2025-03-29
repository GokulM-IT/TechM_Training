package Task_07;
import java.util.LinkedList;

/*
Write a Java program to iterate through all elements in a linked list.
*/

public class IterateLinkedList {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        for (String color : colors) {
            System.out.println(color);
        }
    }
}
