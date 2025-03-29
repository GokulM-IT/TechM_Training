package Task_10;

/*
Write a Java program to represent Interthread communication.
*/

class SharedResource {
    private int value = 0;
    
    public synchronized void increment() {
        value++;
        notify();
    }
    
    public synchronized void decrement() {
        value--;
        notify();
    }
    
    public synchronized void waitForChange() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public int getValue() {
        return value;
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.increment();
                System.out.println("Incremented: " + resource.getValue());
                resource.waitForChange();
            }
        });
        
        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.decrement();
                System.out.println("Decremented: " + resource.getValue());
                resource.waitForChange();
            }
        });
        
        incrementThread.start();
        decrementThread.start();
    }
}
