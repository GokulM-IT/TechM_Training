package Task_07;
import java.util.ArrayList;

/*
Write a Java program to remove the third element from an array list.
*/

public class RemoveThirdElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        colors.remove(2);

        System.out.println("ArrayList after removing third element: " + colors);
    }
}
