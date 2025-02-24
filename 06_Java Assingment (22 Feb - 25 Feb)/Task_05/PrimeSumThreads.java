package Task_05;

/*
Write a Java program that calculates the sum of all prime numbers up to a given limit using multiple threads.
*/

import java.util.concurrent.atomic.AtomicInteger;

public class PrimeSumThreads {
    public static void main(String[] args) throws InterruptedException {
        int limit = 100;
        AtomicInteger sum = new AtomicInteger();

        Thread sumThread = new Thread(() -> {
            for (int i = 2; i <= limit; i++) {
                if (isPrime(i)) {
                    sum.addAndGet(i);
                }
            }
        });

        sumThread.start();
        sumThread.join();

        System.out.println("Sum of prime numbers up to " + limit + ": " + sum);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
