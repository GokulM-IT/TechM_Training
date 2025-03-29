package Task_03;
import java.io.File;

/*
Write a Java program to check if the given pathname is a directory or a file.
*/

public class CheckDirectoryOrFile {
    public static void main(String[] args) {
        File path = new File("your_file_or_directory_path_here");
        if (path.exists()) {
            if (path.isDirectory()) {
                System.out.println("It's a directory.");
            } else if (path.isFile()) {
                System.out.println("It's a file.");
            }
        } else {
            System.out.println("Path does not exist.");
        }
    }
}
