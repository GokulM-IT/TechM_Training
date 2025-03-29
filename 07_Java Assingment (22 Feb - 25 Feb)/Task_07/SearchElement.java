package Task_07;
import java.util.ArrayList;

/*
Write a Java program to search for an element in an array list.
*/

public class SearchElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        boolean found = colors.contains("Green");

        System.out.println("Element 'Green' found: " + found);
    }
}
