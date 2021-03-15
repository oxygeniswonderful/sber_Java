import java.util.Comparator;

public class Car implements Garage {

    private final int carId;
    private final String brand;
    private final String modelName;
    private final int maxVelocity;
    private final int power;
    private final int ownerId;

    public Car(){

        this.power = 0;
        this.carId = 0;
        this.ownerId = 0;
        this.maxVelocity = 0;
        this.brand = "";
        this.modelName = "";
    }

    public Car(int carId, String brand, String modelName, int maxVelocity, int power, int ownerId) {

        this.power = power;
        this.ownerId = ownerId;
        this.maxVelocity = maxVelocity;
        this.carId = carId;
        this.brand = brand;
        this.modelName = modelName;

    }
}
