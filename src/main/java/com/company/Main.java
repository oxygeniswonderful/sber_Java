package com.company;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(0, "Mercedes", "S-class", 350,5500, 228);
        Car car1 = new Car(1, "Mercedes", "E-class", 300,5000, 301);
        Car car2 = new Car(2, "Porsche", "Panamera", 400,6000, 228);
        Car car3 = new Car(3, "Lamborghini", "Aventator", 500, 7000, 288);
        Car car4 = new Car(4,"Ferrari", "CX-5", 490, 6990, 301);
        Owner owner = new Owner("David", "Voskanyan", 21, 228);
        Owner owner1 = new Owner("David", "Voskanyan", 21, 228);
        Owner owner2 = new Owner("Ilya", "Zuev", 20,301);
        Garage_class garage = new Garage_class();
        garage.addNewCar(car,owner);
        garage.addNewCar(car1,owner1);
        garage.addNewCar(car2, owner);
        garage.addNewCar(car3, owner);
        garage.addNewCar(car4, owner2);
        garage.allCarsUniqueOwners();
        garage.meanOwnersAgeOfCarBrand("Mercedes");
        garage.meanCarNumberForEachOwner();
    }
}
