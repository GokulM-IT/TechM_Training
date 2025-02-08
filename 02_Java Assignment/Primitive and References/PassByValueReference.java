package primitiveAndReference;

public class PassByValueReference {
    public static void modifyValues(int number, int[] array) {
        number = 50;
        array[0] = 99;
    }

    public static void main(String[] args) {
        int num = 10;
        int[] arr = {1, 2, 3};

        modifyValues(num, arr);

        System.out.println("Integer after method call: " + num);
        System.out.println("Array after method call: " + arr[0]);
    }
}
