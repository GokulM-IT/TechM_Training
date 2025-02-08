package oops;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2020));
        cars.add(new ElectricCar("Tesla", "Model 3", 2022, 350));
        cars.add(new Car("Ford", "F-150", 2021));
        cars.add(new ElectricCar("Nissan", "Leaf", 2023, 250));

        for (Car car : cars) {
            car.startEngine();
        }
    }
}
