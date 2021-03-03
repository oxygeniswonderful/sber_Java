package com.company;

import java.util.Collection;
import java.util.*;


public interface Garage {

    default boolean is_equal_owner(Owner owner1, Owner owner2) {
        if ((owner1.getName().equals(owner2.getName()) & (owner1.getLastName().equals(owner2.getLastName())) & (owner1.getAge() == owner2.getAge())) & (owner1.getOwnerId() == owner2.getOwnerId())) {
            return true;
        } else return false;
    }

    default boolean is_equal_car(Car car1, Car car2) {
        if ((car1.getCarId() == car2.getCarId()) & (car1.getBrand().equals(car2.getBrand())) & (car1.getMaxVelocity() == car2.getMaxVelocity()) & (car1.getPower() == car2.getPower()) & (car1.getOwnerId() == car2.getOwnerId()) & (car1.getModelName().equals(car2.getModelName()))) {
            return true;
        } else return false;
    }

    HashMap<Owner, HashSet<Car>> list_of_cars_for_owners = new HashMap<>();

    default Collection<Owner> allCarsUniqueOwners() {
        for (Owner owner : list_of_cars_for_owners.keySet()) {
            owner.getInfo();
        }
        return null;
    }

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
class Garage_class implements Garage {

    static class CarParameters implements Comparable<CarParameters> {
        int carparameters;
        int carId;

        public CarParameters(int carparameters, int carId) {
            this.carId = carId;
            this.carparameters = carparameters;
        }

        @Override
        public int compareTo(Garage_class.CarParameters o) {
            if (o.carparameters > this.carparameters)
                return 1;
            if (o.carparameters < this.carparameters)
                return -1;
            return Integer.compare(o.carId, this.carId);
        }
        @Override
        public boolean equals(Object object) {
            if (this == object)
                return true;
            if (object == null || getClass() != object.getClass())
                return false;
            CarParameters c = (CarParameters) object;
            return carId == c.carId;
        }
        @Override
        public int hashCode() {
            return Objects.hash(carId);
        }
    }

    TreeMap<CarParameters, Car> velocity = new TreeMap<>();
    HashMap<String, HashSet<Car>> cars_of_brand = new HashMap<>();
    TreeMap<CarParameters, Car> powers = new TreeMap<>();
    HashMap<Owner, HashSet<Car>> owners = new HashMap<>();
    HashMap<Integer, Owner> list_of_owners = new HashMap<>();
    HashMap<Integer, Car> list_of_cars = new HashMap<>();

    public Garage_class(){
    }

    @Override
    public Collection<Car> topThreeCarsByMaxVelocity() {
        ArrayList<Car> topthree = new ArrayList<Car>();
        CarParameters key = velocity.firstKey();
        while (key != null & topthree.size() < 3) {
            topthree.add(velocity.get(key));
            key = velocity.higherKey(key);
        }
        //for (Car c : topthree)
        //System.out.println(c.getMaxVelocity());
        return topthree;
    }

    @Override
    public Collection<Car> allCarsOfBrand(String brand) {
        if (cars_of_brand.containsKey(brand))
            return cars_of_brand.get(brand);
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
        double sum = 0;
        Collection<Car> cars = allCarsOfBrand(brand);
        double count = cars.size();
        double result;
        for (Car car : cars){
            //System.out.println(list_of_owners.get(car.getOwnerId()).getAge());
            sum += list_of_owners.get(car.getOwnerId()).getAge();
        }
        result = sum / count;
        System.out.println(result);
        //return (int) result;
        return  result;
    }

    @Override
    public double meanCarNumberForEachOwner() {
        double sum = 0.0;
        double result;
        Set<Owner> keys = owners.keySet();
        for(Owner owner : keys)
            sum += owners.get(owner).size();
        result = sum / keys.size();
        //System.out.println(result);
        return result;
    }

    @Override
    public Car removeCar(int carId) {
        Car deleted_car = list_of_cars.remove(carId);
        if (deleted_car == null)
            return null;
        Owner deleted_owner = new Owner(deleted_car.getOwnerId());
        owners.get(deleted_owner).remove(new Car(carId));
        if (owners.get(deleted_owner).size() == 0) {
            owners.remove(deleted_owner);
            list_of_owners.remove(deleted_owner.getOwnerId());
        }
        String brand = deleted_car.getBrand();
        cars_of_brand.get(brand).remove(new Car(carId));
        velocity.remove(new CarParameters(deleted_car.getMaxVelocity(), carId));
        powers.remove(new CarParameters(deleted_car.getPower(), carId));
        return deleted_car;
    }
    @Override
    public void addNewCar(Car car, Owner owner) {
        int c_owner = 0;
        for (Owner ow : list_of_cars_for_owners.keySet()) {
            if (is_equal_owner(owner, ow))
                c_owner += 1;
        }
        if ((!(list_of_cars_for_owners.keySet().contains(owner))) & (c_owner == 0)) {
            HashSet<Car> cars = new HashSet<>();
            cars.add(car);
            list_of_cars_for_owners.put(owner, cars);
        }
        if ((list_of_cars_for_owners.containsKey(owner)) & (c_owner == 0)) {
            list_of_cars_for_owners.get(owner).add(car);
        }
        velocity.put(new CarParameters(car.getMaxVelocity(), car.getCarId()), car);
        powers.put(new CarParameters(car.getPower(), car.getCarId()), car);
        list_of_owners.put(owner.getOwnerId(), owner);
        list_of_cars.put(car.getCarId(), car);

        String brand = car.getBrand();
        if (!cars_of_brand.containsKey(brand)) {
            HashSet<Car> helper = new HashSet<>();
            helper.add(car);
            cars_of_brand.put(brand, helper);
        }
        else cars_of_brand.get(brand).add(car);
        if (!owners.containsKey(owner)) {
            HashSet<Car> helper = new HashSet<>();
            helper.add(car);
            owners.put(owner, helper);
        }
        else owners.get(owner).add(car);
    }
}