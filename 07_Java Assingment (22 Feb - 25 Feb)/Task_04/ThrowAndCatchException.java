package Task_04;

/*
Write a Java program that throws an exception and catches it using a try-catch block.
*/

public class ThrowAndCatchException {
    public static void main(String[] args) {
        try {
            throw new Exception("This is a custom exception.");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
