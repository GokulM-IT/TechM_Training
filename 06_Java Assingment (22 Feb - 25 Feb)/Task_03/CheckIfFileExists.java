package Task_03;
import java.io.File;

/*
Write a Java program to check if a file or directory specified by pathname exists or not.
*/

public class CheckIfFileExists {
    public static void main(String[] args) {
        File file = new File("your_file_or_directory_path_here");
        if (file.exists()) {
            System.out.println("File or directory exists.");
        } else {
            System.out.println("File or directory does not exist.");
        }
    }
}
