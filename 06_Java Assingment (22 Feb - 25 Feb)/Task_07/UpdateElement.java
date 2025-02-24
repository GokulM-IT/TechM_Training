package Task_07;
import java.util.ArrayList;

/*
Write a Java program to update an array element by the given element.
*/

public class UpdateElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        colors.set(2, "Orange");

        System.out.println("ArrayList after update: " + colors);
    }
}
