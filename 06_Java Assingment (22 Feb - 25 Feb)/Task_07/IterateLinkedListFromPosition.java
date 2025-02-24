package Task_07;
import java.util.LinkedList;

/*
Write a Java program to iterate through all elements in a linked list starting at the specified position.
*/

public class IterateLinkedListFromPosition {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        int startPosition = 2;

        for (int i = startPosition; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }
    }
}
