package Task_05;

/*
Write a Java program that performs matrix multiplication using multiple threads.
*/

public class MatrixMultiplication {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrixA = {
            {1, 2},
            {3, 4}
        };
        
        int[][] matrixB = {
            {5, 6},
            {7, 8}
        };
        
        int[][] result = new int[matrixA.length][matrixB[0].length];

        Thread[] threads = new Thread[matrixA.length * matrixB[0].length];
        int threadIndex = 0;

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                final int row = i;
                final int col = j;
                threads[threadIndex++] = new Thread(() -> {
                    result[row][col] = 0;
                    for (int k = 0; k < matrixA[0].length; k++) {
                        result[row][col] += matrixA[row][k] * matrixB[k][col];
                    }
                });
            }
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Result of Matrix Multiplication:");
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
