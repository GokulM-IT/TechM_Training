package Task_07;
import java.util.ArrayList;

/*
Write a Java program to retrieve an element (at a specified index) from a given array list.
*/

public class RetrieveElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        String color = colors.get(2);

        System.out.println("Element at index 2: " + color);
    }
}
