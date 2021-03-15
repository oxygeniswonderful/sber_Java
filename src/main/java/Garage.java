import java.util.*;

public interface Garage {

    public HashMap<Owner, ArrayList<Car>> carsOwners = new HashMap<>();
    public HashMap<String, ArrayList<Car>> brandsOfCars = new HashMap<>();
    public HashMap<Integer, Owner> ownersId = new HashMap<>();
    public ArrayList<Car> listOfCars = new ArrayList<>();

}
