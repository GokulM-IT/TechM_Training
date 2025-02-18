package threadExercise.InterThreadCommunication;

class Customer {
    int amount = 10000;

    synchronized void withdraw(int amount) {
        System.out.println("going to withdraw...");

        if (this.amount < amount) {
            System.out.println("Less balance; waiting for deposit...");
            try {
                wait();
            } catch (Exception error) {
                System.out.println("Error: " + error);
            }
        }
        this.amount -= amount;
        System.out.println("withdraw completed...");
    }

    synchronized void deposit(int amount) {
        System.out.println("going to deposit...");
        this.amount += amount;
        System.out.println("deposit completed... ");
        notify();
    }
}

class InterThreadMain {
    public static void main(String[] args) {
        Customer customer = new Customer();
        new Thread() {
            public void run() {
                int amount = 15000;
                customer.withdraw(amount);
            }
        }.start();
        int amount = 10000;
        new Thread(() -> customer.deposit(amount)).start();
    }
}