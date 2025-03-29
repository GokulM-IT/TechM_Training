package Task_07;
import java.util.ArrayList;
import java.util.Collections;

/*
Write a Java program to sort a given array list.
*/

public class SortArrayList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        Collections.sort(colors);

        System.out.println("Sorted ArrayList: " + colors);
    }
}
