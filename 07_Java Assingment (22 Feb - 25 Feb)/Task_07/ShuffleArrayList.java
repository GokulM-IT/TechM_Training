package Task_07;
import java.util.ArrayList;
import java.util.Collections;

/*
Write a Java program to shuffle elements in an array list.
*/

public class ShuffleArrayList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        Collections.shuffle(colors);

        System.out.println("Shuffled ArrayList: " + colors);
    }
}
