package threadExercise.threadsImplementation;

class GTask1 extends Thread {
    public void run() {
        System.out.println("From GTask1! " + this.getName());
        // System.out.println(10/0);
    }
}

class GTask2 implements Runnable {
    public void run() {
        System.out.println("From GTask2!");
//        System.out.println(10 / 0);
    }
}

public class ThreadExample {
    public static void main(String[] args) {//Thread 1
        System.out.println("From Main thread!");
        System.out.println("From Main thread!");
        System.out.println("From Main thread!");
        GTask1 gTask1 = new GTask1();
        gTask1.start();//calls run method-Thread 2
        //gTask1.run();
        GTask2 gTask2 = new GTask2();
        Thread thread = new Thread(gTask2);
        new Thread(gTask2).start();//Thread 3
        thread.start();//Thread 4
        gTask2.run();
//        System.out.println(10 / 0);
    }
}
