package systemFileOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BufferReaderOperations {
    static void getInputUsingBufferedReaderClass() throws IOException {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the input: ");
        // Reading data using readLine
        String word = reader.readLine();
        int num = Integer.parseInt(reader.readLine());
        float decimalNumber = Float.parseFloat(reader.readLine());

        // Printing the read line
        System.out.println("The given input:" + word);
        System.out.println("The given input:" + num);
        System.out.println("The given input:" + decimalNumber);
    }

    void getInputUsingScannerClass() {
        // Using Scanner for Getting Input from User
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the input string : ");
        String s1 = s.nextLine();
        System.out.println("You entered string " + s1);

        System.out.print("Enter the input integer : ");
        int a = s.nextInt();
        System.out.println("You entered integer " + a);

        System.out.print("Enter the input float : ");
        float b = s.nextFloat();
        System.out.println("You entered float " + b);
    }

    public static void main(String[] args) throws IOException {
        BufferReaderOperations obj = new BufferReaderOperations();
        obj.getInputUsingScannerClass();

        try {
            BufferReaderOperations.getInputUsingBufferedReaderClass();
        } catch (IOException error) {
            System.out.println("Error Occurred: " + error);
        }
    }
}
