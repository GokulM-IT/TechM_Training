package Task_05;

/*
Write a Java program that creates two threads to find and print even and odd numbers from 1 to 20.
*/

public class EvenOddThreads {
    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                if (i % 2 == 0) {
                    System.out.println("Even: " + i);
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                if (i % 2 != 0) {
                    System.out.println("Odd: " + i);
                }
            }
        });

        evenThread.start();
        oddThread.start();
    }
}
