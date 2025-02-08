package oops;

class ElectricCar extends Car {
    private int batteryRange;

    public ElectricCar(String make, String model, int year, int batteryRange) {
        super(make, model, year);
        this.batteryRange = batteryRange;
    }

    public int getBatteryRange() {
        return batteryRange;
    }

    public void setBatteryRange(int batteryRange) {
        this.batteryRange = batteryRange;
    }

    public void chargeBattery() {
        System.out.println("The battery of the " + getMake() + " " + getModel() + " is being charged.");
    }

    public void startEngine() {
        System.out.println("The electric engine of the " + getMake() + " " + getModel() + " (" + getYear() + ") has started silently.");
    }
}
