package Task_03;
import java.io.File;

/*
Write a Java program to get a list of all file/directory names in the given directory.
*/

public class ListFilesInDirectory {
    public static void main(String[] args) {
        File directory = new File("your_directory_path_here");
        if (directory.isDirectory()) {
            String[] fileList = directory.list();
            if (fileList != null) {
                for (String file : fileList) {
                    System.out.println(file);
                }
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }
}
