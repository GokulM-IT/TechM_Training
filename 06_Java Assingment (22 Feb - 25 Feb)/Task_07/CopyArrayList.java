package Task_07;
import java.util.ArrayList;

/*
Write a Java program to copy one array list into another.
*/

public class CopyArrayList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        ArrayList<String> copyOfColors = new ArrayList<>(colors);

        System.out.println("Copied ArrayList: " + copyOfColors);
    }
}
