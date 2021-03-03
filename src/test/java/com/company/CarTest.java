package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car = new Car(0, "Mercedes", "S-class", 350, 5500, 228);

    @Test
    void getCarId() throws Exception {

        int expected = 0;
        int actual = car.getCarId();
        assertEquals(expected, actual);
    }

    @Test
    void getBrand() throws Exception {

        String expected = "Mercedes";
        String actual = car.getBrand();
        assertEquals(expected, actual);
    }

    @Test
    void getModelName() throws Exception {

        String expected = "S-class";
        String actual = car.getModelName();
        assertEquals(expected, actual);
    }

    @Test
    void getMaxVelocity() throws Exception {

        int expected = 350;
        int actual = car.getMaxVelocity();
        assertEquals(expected, actual);
    }

    @Test
    void getPower() throws Exception {

        int expected = 5500;
        int actual = car.getPower();
        assertEquals(expected, actual);
    }

    @Test
    void getOwnerId() throws Exception {

        int expected = 228;
        int actual = car.getOwnerId();
        assertEquals(expected, actual);
    }
}