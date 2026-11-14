package aufgabe5;

import aufgabe4.Car;

/**
 * Aufgabe 5: Vererbung und Polymorphie.
 */
public class ElectricCar extends Car {
    private final double batteryCapacity; // in kWh

    public ElectricCar(String marke, int baujahr, int kmStand, double batteryCapacity) {
        super(marke, baujahr, kmStand);
        if (batteryCapacity <= 0) {
            throw new IllegalArgumentException("Die Batteriekapazität muss größer als 0 sein.");
        }
        this.batteryCapacity = batteryCapacity;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Batterie: " + batteryCapacity + " kWh";
    }
}
