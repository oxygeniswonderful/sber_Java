package com.company;

import java.util.Comparator;
import java.util.Objects;

public class Car {
    private final int carId;
    private final String brand;
    private final String modelName;
    private final int maxVelocity;
    private final int power;
    private final int ownerId;

    public Car(int carId, String brand, String modelName, int maxVelocity, int power, int ownerId) {
        this.carId = carId;
        this.brand = brand;
        this.modelName = modelName;
        this.maxVelocity = maxVelocity;
        this.power = power;
        this.ownerId = ownerId;
    }

    public Car(int carId) {
        this.carId = carId;
        this.brand = "";
        this.ownerId = 0;
        this.maxVelocity = 0;
        this.modelName = "";
        this.power = 0;
    }

    public int getCarId() {
        return this.carId;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getMaxVelocity() {
        return this.maxVelocity;
    }

    public int getPower() {
        return this.power;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public void getInfo() {
        System.out.printf("carId : %d \t brand : %s \t modelName : %s \t " +
                "maxVelocity : %d \t power : %d \t ownerId %d \n",
                this.carId, this.brand, this.modelName, this.maxVelocity, this.power, this.ownerId);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        Car car = (Car) object;
        return carId == car.carId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId);
    }

}
