package primitiveAndReference;

public class TrailingZeroes {
    public static int countTrailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 100;
        System.out.println("Trailing zeroes in " + number + "! : " + countTrailingZeroes(number));
    }
}
