package Task_07;
import java.util.ArrayList;

/*
Write a Java program to create an array list, add some colors (strings) and print out the collection.
*/

public class ColorsArrayList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        System.out.println("ArrayList of colors: " + colors);
    }
}
