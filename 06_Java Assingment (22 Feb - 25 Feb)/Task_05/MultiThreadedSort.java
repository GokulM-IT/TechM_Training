package Task_05;

/*
Write a Java program that sorts an array of integers using multiple threads.
*/

import java.util.Arrays;

public class MultiThreadedSort {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {5, 3, 8, 6, 1, 7, 2, 4};
        
        Thread sortingThread = new Thread(() -> {
            Arrays.sort(array);
            System.out.println("Sorted Array: " + Arrays.toString(array));
        });

        sortingThread.start();
        sortingThread.join();
    }
}
