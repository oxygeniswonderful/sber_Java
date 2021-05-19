package com.company;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

class GarageImpl implements Garage {

    final TreeMap<CarParameters, Car> velocity = new TreeMap<>();
    final HashMap<String, HashSet<Car>> carsOfBrand = new HashMap<>();
    final TreeMap<CarParameters, Car> powers = new TreeMap<>();
    final HashMap<Owner, HashSet<Car>> owners = new HashMap<>();
    final HashMap<Integer, Owner> kitOfOwners = new HashMap<>();
    final HashMap<Integer, Car> kitOfCars = new HashMap<>();

    @Override
    public Collection<Owner> allCarsUniqueOwners() {
        return owners.keySet();
    }

    @Override
    public Collection<Car> topThreeCarsByMaxVelocity() {
        ArrayList<Car> topThree = new ArrayList<Car>();
        CarParameters key = velocity.firstKey();
        while (key != null & topThree.size() < 3) {
            topThree.add(velocity.get(key));
            key = velocity.higherKey(key);
        }
        return topThree;
    }

    @Override
    public Collection<Car> allCarsOfBrand(String brand) {
        if (carsOfBrand.containsKey(brand))
            return carsOfBrand.get(brand);
        return new HashSet<Car>();
    }

    @Override
    public Collection<Car> carsWithPowerMoreThan(int power) {
        for (Car c : powers.headMap(new CarParameters(power, Integer.MAX_VALUE)).values())
            c.getInfo();
        return powers.headMap(new CarParameters(power, Integer.MAX_VALUE)).values();
    }

    @Override
    public Collection<Car> allCarsOfOwner(Owner owner) {
        if (owners.containsKey(owner)) {
            System.out.println(owners.get(owner));
            return owners.get(owner);
        }
        return new HashSet<Car>();
    }

    @Override
    public double meanOwnersAgeOfCarBrand(String brand) {
        double summ = 0;
        Collection<Car> cars = allCarsOfBrand(brand);
        double count = cars.size();
        double result;
        for (Car car : cars) {
            summ += kitOfOwners.get(car.getOwnerId()).getAge();
        }
        result = summ / count;
        System.out.println(result);
        return result;
    }

    @Override
    public double meanCarNumberForEachOwner() {
        double summ = 0.0;
        double result;
        Set<Owner> keys = owners.keySet();
        for (Owner owner : keys)
            summ += owners.get(owner).size();
        result = summ / keys.size();
        return result;
    }

    @Override
    public Car removeCar(int carId) {
        Car carDelete = kitOfCars.remove(carId);
        if (carDelete == null)
            return null;
        Owner deleted_owner = new Owner(carDelete.getOwnerId());
        owners.get(deleted_owner).remove(new Car(carId));
        if (owners.get(deleted_owner).size() == 0) {
            owners.remove(deleted_owner);
            kitOfOwners.remove(deleted_owner.getOwnerId());
        }
        String brand = carDelete.getBrand();
        carsOfBrand.get(brand).remove(new Car(carId));
        velocity.remove(new CarParameters(carDelete.getMaxVelocity(), carId));
        powers.remove(new CarParameters(carDelete.getPower(), carId));
        return carDelete;
    }

    @Override
    public void addNewCar(Car car, Owner owner) {
        int countOfOwner = 0;
        for (Owner ow : owners.keySet()) {
            if (owner.EqualOwner(owner, ow))
                countOfOwner += 1;
        }

        if ((!(owners.keySet().contains(owner))) & (countOfOwner == 0)) {
            HashSet<Car> cars = new HashSet<>();
            cars.add(car);
            owners.put(owner, cars);
        }

        if ((owners.containsKey(owner)) & (countOfOwner == 0)) {
            owners.get(owner).add(car);
        }

        velocity.put(new CarParameters(car.getMaxVelocity(), car.getCarId()), car);
        powers.put(new CarParameters(car.getPower(), car.getCarId()), car);
        kitOfOwners.put(owner.getOwnerId(), owner);
        kitOfCars.put(car.getCarId(), car);
        String brand = car.getBrand();

        if (!carsOfBrand.containsKey(brand)) {
            HashSet<Car> helper = new HashSet<>();
            helper.add(car);
            carsOfBrand.put(brand, helper);
        } else carsOfBrand.get(brand).add(car);

        if (!owners.containsKey(owner)) {
            HashSet<Car> helper = new HashSet<>();
            helper.add(car);
            owners.put(owner, helper);
        } else owners.get(owner).add(car);
    }
}
