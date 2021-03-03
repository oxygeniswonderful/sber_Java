package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {

    Owner owner1 = new Owner("David", "Voskanyan", 21, 228);
    Owner owner2 = new Owner("Ilya", "Zuev", 20,301);
    Owner owner = new Owner("David", "Voskanyan", 21, 228);

    @Test
    boolean is_equal_owner(Owner owner, Owner owner1) throws Exception{

        boolean expected_1 = true;
        boolean expected_2 = false;
        boolean actual_1 = is_equal_owner(owner, owner1);
        assertTrue(expected_1 == actual_1);

        return expected_1;
    }
/*
    @Test
    void is_equal_car() throws Exception{

        assertEquals(expected, actual);
    }

    @Test
    void allCarsUniqueOwners() throws Exception{

        assertEquals(expected, actual);
    } */
}