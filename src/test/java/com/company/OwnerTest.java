package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {
    Owner owner = new Owner("David", "Voskanyan", 21, 228);

    @Test
    void getName() throws Exception{

        String expected = "David";
        String actual = owner.getName();
        assertEquals(expected, actual);
    }

    @Test
    void getLastName() throws Exception{

        String expected = "Voskanyan";
        String actual = owner.getLastName();
        assertEquals(expected, actual);
    }

    @Test
    void getAge() throws Exception{

        int expected = 21;
        int actual = owner.getAge();
        assertEquals(expected, actual);
    }

    @Test
    void getOwnerId() throws Exception{

        int expected = 228;
        int actual = owner.getOwnerId();
        assertEquals(expected, actual);
    }
}