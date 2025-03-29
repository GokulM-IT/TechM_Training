package Task_03;
import java.io.File;
import java.util.Date;

/*
Write a Java program to determine the last modified date of a file.
*/

public class LastModifiedDate {
    public static void main(String[] args) {
        File file = new File("your_file_path_here");
        if (file.exists()) {
            long lastModified = file.lastModified();
            Date date = new Date(lastModified);
            System.out.println("Last modified date: " + date);
        } else {
            System.out.println("File does not exist.");
        }
    }
}
