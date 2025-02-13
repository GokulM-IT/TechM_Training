package threadExercise.multiThreadOperations;

class ThreadTwo implements Runnable{
    public void run() {
        System.out.println("ThreadTwo!");
        System.out.println("ThreadTwo!");
        System.out.println(10/0);
    }
}

public class MyThread {
    public static void main(String[] args) {
        ThreadTwo threadTwo = new ThreadTwo();
        Thread thread1 = new Thread(threadTwo);
        Thread thread2 = new Thread(threadTwo);

        thread1.start();
        thread2.start();

        threadTwo.run();
    }
}
