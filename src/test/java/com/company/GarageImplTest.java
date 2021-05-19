package com.company;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplTest {

    @Test
    void allCarsUniqueOwners(){
        GarageImpl myGarage = new GarageImpl();
        Owner owner1 = new Owner("David", "Voskanyan", 21, 228);
        Owner owner2 = new Owner("Ilya", "Zuev", 20, 301);
        Car car1 = new Car(1, "Mercedes", "E-class", 300,5000, 301);
        Car car2 = new Car(2, "Porsche", "Panamera", 400,6000, 228);
        Car car3 = new Car(3, "Lamborghini", "Aventator", 500, 7000, 288);
        Car car4 = new Car(4,"Ferrari", "CX-5", 490, 6990, 301);
        myGarage.addNewCar(car1, owner1);
        myGarage.addNewCar(car2, owner2);
        myGarage.addNewCar(car3, owner2);
        myGarage.addNewCar(car4, owner1);
        assertEquals(new ArrayList<>(myGarage.allCarsUniqueOwners()), myGarage.allCarsUniqueOwners().stream().distinct().collect(Collectors.toList()));

    }

    @Test
    void topThreeCarsByMaxVelocity() throws Exception {
        GarageImpl myGarage = new GarageImpl();
        Owner owner1 = new Owner("David", "Voskanyan", 21, 228);
        Owner owner2 = new Owner("Ilya", "Zuev", 20, 301);
        Car car1 = new Car(1, "Mercedes", "E-class", 300,5000, 301);
        Car car2 = new Car(2, "Porsche", "Panamera", 400,6000, 228);
        Car car3 = new Car(3, "Lamborghini", "Aventator", 500, 7000, 288);
        Car car4 = new Car(4,"Ferrari", "CX-5", 490, 6990, 301);
        myGarage.addNewCar(car1, owner1);
        myGarage.addNewCar(car2, owner2);
        myGarage.addNewCar(car3, owner2);
        myGarage.addNewCar(car4, owner1);
        String actual = "";
        for (Car c : myGarage.topThreeCarsByMaxVelocity()) {
            actual += c.getCarId();
        }
        String expected = "342";
        assertEquals(expected, actual);
    }

    @Test
    void allCarsOfBrand() {
        GarageImpl myGarage = new GarageImpl();
        Owner owner1 = new Owner("David", "Voskanyan", 21, 228);
        Owner owner2 = new Owner("Ilya", "Zuev", 20, 301);
        Car car = new Car(0, "Mercedes", "S-class", 350,5500, 228);
        Car car1 = new Car(1, "Mercedes", "E-class", 300,5000, 301);
        Car car2 = new Car(2, "Porsche", "Panamera", 400,6000, 228);
        Car car3 = new Car(3, "Lamborghini", "Aventator", 500, 7000, 288);
        Car car4 = new Car(4,"Ferrari", "CX-5", 490, 6990, 301);
        myGarage.addNewCar(car1, owner1);
        myGarage.addNewCar(car2, owner2);
        myGarage.addNewCar(car3, owner2);
        myGarage.addNewCar(car4, owner1);
        myGarage.addNewCar(car, owner1);
        int actual = 0;
        int expected = 2;
        for (Car c : myGarage.allCarsOfBrand("Mercedes")) {
            if (c.getBrand().equals("Mercedes"))
                actual += 1;
        }
        assertEquals(actual, expected);
    }

    @Test
    void carsWithPowerMoreThan() {
        GarageImpl myGarage = new GarageImpl();
        Owner owner1 = new Owner("David", "Voskanyan", 21, 228);
        Owner owner2 = new Owner("Ilya", "Zuev", 20, 301);
        Car car1 = new Car(1, "Mercedes", "E-class", 300,5000, 301);
        Car car2 = new Car(2, "Porsche", "Panamera", 400,6000, 228);
        Car car3 = new Car(3, "Lamborghini", "Aventator", 500, 7000, 288);
        Car car4 = new Car(4,"Ferrari", "CX-5", 490, 6990, 301);
        myGarage.addNewCar(car1, owner1);
        myGarage.addNewCar(car2, owner2);
        myGarage.addNewCar(car3, owner2);
        myGarage.addNewCar(car4, owner1);
        String actual = "";
        String expected = "342";
        for (Car fastestCar : myGarage.carsWithPowerMoreThan(5001)) {
           actual += fastestCar.getCarId();
        }
        assertEquals(actual, expected);
    }

    @Test
    void allCarsOfOwner() {
        GarageImpl myGarage = new GarageImpl();
        Owner owner1 = new Owner("David", "Voskanyan", 21, 228);
        Owner owner2 = new Owner("Ilya", "Zuev", 20, 301);
        Car car1 = new Car(1, "Mercedes", "E-class", 300,5000, 301);
        Car car2 = new Car(2, "Porsche", "Panamera", 400,6000, 228);
        Car car3 = new Car(3, "Lamborghini", "Aventator", 500, 7000, 288);
        Car car4 = new Car(4,"Ferrari", "CX-5", 490, 6990, 301);
        myGarage.addNewCar(car1, owner1);
        myGarage.addNewCar(car2, owner2);
        myGarage.addNewCar(car3, owner2);
        myGarage.addNewCar(car4, owner1);
        String actual = "";
        String expected = "23";
        for (Car c : myGarage.allCarsOfOwner(owner2)) {
            actual += c.getCarId();
        }
        assertEquals(actual, expected);
    }

    @Test
    void meanOwnersAgeOfCarBrand() {
        GarageImpl myGarage = new GarageImpl();
        Owner owner1 = new Owner("David", "Voskanyan", 21, 228);
        Owner owner2 = new Owner("Ilya", "Zuev", 20, 301);
        Car car = new Car(0, "Mercedes", "S-class", 350,5500, 228);
        Car car1 = new Car(1, "Mercedes", "E-class", 300,5000, 301);
        Car car2 = new Car(2, "Porsche", "Panamera", 400,6000, 228);
        Car car3 = new Car(3, "Lamborghini", "Aventator", 500, 7000, 288);
        Car car4 = new Car(4,"Ferrari", "CX-5", 490, 6990, 301);
        myGarage.addNewCar(car1, owner1);
        myGarage.addNewCar(car2, owner2);
        myGarage.addNewCar(car3, owner2);
        myGarage.addNewCar(car4, owner1);
        myGarage.addNewCar(car, owner2);
        assertEquals(myGarage.meanOwnersAgeOfCarBrand("Mercedes"), 20.5);
    }

    @Test
    void meanCarNumberForEachOwner() {
        GarageImpl myGarage = new GarageImpl();
        Owner owner1 = new Owner("David", "Voskanyan", 21, 228);
        Owner owner2 = new Owner("Ilya", "Zuev", 20, 301);
        Car car = new Car(0, "Mercedes", "S-class", 350,5500, 228);
        Car car1 = new Car(1, "Mercedes", "E-class", 300,5000, 301);
        Car car2 = new Car(2, "Porsche", "Panamera", 400,6000, 228);
        Car car3 = new Car(3, "Lamborghini", "Aventator", 500, 7000, 288);
        Car car4 = new Car(4,"Ferrari", "CX-5", 490, 6990, 301);
        myGarage.addNewCar(car1, owner1);
        myGarage.addNewCar(car2, owner2);
        myGarage.addNewCar(car3, owner2);
        myGarage.addNewCar(car4, owner1);
        myGarage.addNewCar(car, owner2);
        assertEquals(myGarage.meanCarNumberForEachOwner(), 2.5);
    }

    @Test
    void removeCar() {
        GarageImpl myGarage = new GarageImpl();
        Owner owner1 = new Owner("David", "Voskanyan", 21, 228);
        Owner owner2 = new Owner("Ilya", "Zuev", 20, 301);
        Car car = new Car(0, "Mercedes", "S-class", 350,5500, 228);
        Car car1 = new Car(1, "Mercedes", "E-class", 300,5000, 301);
        Car car2 = new Car(2, "Porsche", "Panamera", 400,6000, 228);
        Car car3 = new Car(3, "Lamborghini", "Aventator", 500, 7000, 288);
        Car car4 = new Car(4,"Ferrari", "CX-5", 490, 6990, 301);
        myGarage.addNewCar(car1, owner1);
        myGarage.addNewCar(car2, owner1);
        myGarage.addNewCar(car3, owner2);
        myGarage.addNewCar(car4, owner1);
        myGarage.addNewCar(car, owner2);
        myGarage.removeCar(2);
        int expected = 2;
        int actual = myGarage.allCarsOfOwner(owner1).size();
        assertEquals(actual, expected);
    }

    @Test
    void addNewCar() {
        GarageImpl myGarage = new GarageImpl();
        Owner owner1 = new Owner("David", "Voskanyan", 21, 228);
        Car car2 = new Car(2, "Porsche", "Panamera", 400,6000, 228);
        Car car3 = new Car(3, "Lamborghini", "Aventator", 500, 7000, 288);
        myGarage.addNewCar(car2, owner1);
        myGarage.addNewCar(car3, owner1);
        assertNotNull(myGarage);
    }
}