package Task_03;
import java.io.File;
import java.io.FilenameFilter;

/*
Write a Java program to get specific files with extensions from a specified folder.
*/

public class ListFilesWithExtension {
    public static void main(String[] args) {
        File directory = new File("your_directory_path_here");
        String extension = ".txt";

        FilenameFilter filter = (dir, name) -> name.endsWith(extension);

        String[] files = directory.list(filter);
        if (files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        }
    }
}
