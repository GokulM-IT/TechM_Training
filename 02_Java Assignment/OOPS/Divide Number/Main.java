package oops.divideNumber;

public class Main {
    public static int[] divideWithoutOperators(int dividend, int divisor) {
        if (divisor == 0) {
            System.out.println("Error: Division by zero");
            return new int[]{0, 0};
        }

        int quotient = 0;
        int remainder = Math.abs(dividend);

        while (remainder >= Math.abs(divisor)) {
            remainder -= Math.abs(divisor);
            quotient++;
        }

        if ((dividend < 0) != (divisor < 0)) {
            quotient = -quotient;
        }

        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        int dividend = 20;
        int divisor = 3;

        int[] result = divideWithoutOperators(dividend, divisor);
        System.out.println("Quotient: " + result[0] + ", Remainder: " + result[1]);
    }
}
