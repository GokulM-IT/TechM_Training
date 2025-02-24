package Task_03;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
Write a Java program to read the contents of a file into a byte array.
*/

public class ReadFileIntoByteArray {
    public static void main(String[] args) {
        File file = new File("your_file_path_here");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] data = new byte[(int) file.length()];
                fis.read(data);
                System.out.println("File content as byte array: " + new String(data));
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}
