package Task_03;
import java.io.File;

/*
Write a Java program to check if a file or directory has read and write permissions.
*/

public class CheckPermissions {
    public static void main(String[] args) {
        File file = new File("your_file_or_directory_path_here");
        if (file.exists()) {
            System.out.println("Read permission: " + file.canRead());
            System.out.println("Write permission: " + file.canWrite());
        } else {
            System.out.println("File or directory does not exist.");
        }
    }
}
