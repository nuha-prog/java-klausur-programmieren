package aufgabe5;

import aufgabe4.Car;

public class Main {
    public static void main(String[] args) {
        // Polymorphie: Variablentyp Car, tatsächliches Objekt ist teils ElectricCar
        Car[] fuhrpark = {
            new Car("VW", 2019, 45000),
            new ElectricCar("Tesla", 2022, 12000, 75.0)
        };

        for (Car auto : fuhrpark) {
            auto.drive(100);
            System.out.println(auto); // ruft je nach Objekt die passende toString()-Version auf
        }
    }
}
