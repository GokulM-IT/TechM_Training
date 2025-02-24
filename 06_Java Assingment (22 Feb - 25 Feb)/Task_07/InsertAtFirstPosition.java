package Task_07;
import java.util.ArrayList;

/*
Write a Java program to insert an element into the array list at the first position.
*/

public class InsertAtFirstPosition {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        colors.add(0, "Purple");

        System.out.println("ArrayList after inserting at first position: " + colors);
    }
}
