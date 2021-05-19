package com.company;

import java.util.Objects;

public class CarParameters implements Comparable<CarParameters> {
    int carParameters;
    int carId;

    public CarParameters(int carParameters, int carId) {
        this.carId = carId;
        this.carParameters = carParameters;
    }

    @Override
    public int compareTo(CarParameters o) {
        if (o.carParameters > this.carParameters)
            return 1;
        if (o.carParameters < this.carParameters)
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