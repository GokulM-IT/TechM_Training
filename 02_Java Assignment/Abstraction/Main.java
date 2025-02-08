package abstraction;

abstract class Animal {
    public abstract void makeSound();
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("The dog is barking.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();
    }
}
