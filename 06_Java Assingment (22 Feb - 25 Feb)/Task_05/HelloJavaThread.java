package Task_05;

/*
Write a Java program to create a basic Java thread that prints "Hello, Java!" when executed.
*/

public class HelloJavaThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hello, Java!"));
        thread.start();
    }
}
