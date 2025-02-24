package Task_04;

/*
Write a Java program to create a method that takes an integer as a parameter and throws an exception if the number is odd.
*/

public class OddNumberException {
    public static void main(String[] args) {
        try {
            checkEvenNumber(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkEvenNumber(int number) throws Exception {
        if (number % 2 != 0) {
            throw new Exception("The number is odd. Exception thrown!");
        } else {
            System.out.println("The number is even.");
        }
    }
}
