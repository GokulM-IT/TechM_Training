package Task_03;
import java.io.File;

/*
Write a Java program to get the file size in bytes, KB, MB.
*/

public class FileSize {
    public static void main(String[] args) {
        File file = new File("your_file_path_here");
        if (file.exists()) {
            long bytes = file.length();
            double kilobytes = bytes / 1024.0;
            double megabytes = kilobytes / 1024.0;

            System.out.println("File size in bytes: " + bytes);
            System.out.println("File size in KB: " + kilobytes);
            System.out.println("File size in MB: " + megabytes);
        } else {
            System.out.println("File does not exist.");
        }
    }
}
