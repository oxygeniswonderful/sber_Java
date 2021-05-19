package com.company;

import java.util.Collection;
import java.util.*;


public interface Garage {

    Collection<Owner> allCarsUniqueOwners();

    /**
     * \2
     * Complexity should be less than O(n)
     */

    Collection<Car> topThreeCarsByMaxVelocity();

    /**
     * 3
     * Complexity should be O(1)
     */
    Collection<Car> allCarsOfBrand(String brand);

    /**
     * 4
     * Complexity should be less than O(n)
     */
    Collection<Car> carsWithPowerMoreThan(int power);

    /**
     * 5
     * Complexity should be O(1)
     */
    Collection<Car> allCarsOfOwner(Owner owner);

    /**
     * 6
     *
     * @return mean value of owner age that has cars with given brand
     */
    double meanOwnersAgeOfCarBrand(String brand);

    /**
     * 7
     *
     * @return mean value of cars for all owners
     */
    double meanCarNumberForEachOwner();

    /**
     * 8
     * Complexity should be less than O(n)
     *
     * @return removed car
     */
    Car removeCar(int carId);

    /**
     * 9
     * Complexity should be less than O(n)
     */
    void addNewCar(Car car, Owner owner);
}
