package Task_06;
import java.util.List;

/*
Write a Java program to create a generic method that takes a list of numbers and returns the sum of all the even and odd numbers.
*/

public class SumEvenAndOdd {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int[] result = sumEvenAndOdd(numbers);
        System.out.println("Sum of even numbers: " + result[0]);
        System.out.println("Sum of odd numbers: " + result[1]);
    }

    public static <T extends Number> int[] sumEvenAndOdd(List<T> list) {
        int sumEven = 0, sumOdd = 0;
        for (T number : list) {
            if (number.intValue() % 2 == 0) {
                sumEven += number.intValue();
            } else {
                sumOdd += number.intValue();
            }
        }
        return new int[]{sumEven, sumOdd};
    }
}
