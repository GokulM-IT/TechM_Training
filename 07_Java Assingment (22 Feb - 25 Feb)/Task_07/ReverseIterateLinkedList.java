package Task_07;
import java.util.LinkedList;

/*
Write a Java program to iterate a linked list in reverse order.
*/

public class ReverseIterateLinkedList {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        for (int i = colors.size() - 1; i >= 0; i--) {
            System.out.println(colors.get(i));
        }
    }
}
