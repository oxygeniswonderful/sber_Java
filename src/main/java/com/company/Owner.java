package com.company;

import java.util.Objects;

public class Owner {
    private final String name;
    private final String lastName;
    private final int age;
    private final int ownerId;

    public Owner(String name, String lastName, int age, int ownerId) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.ownerId = ownerId;
    }

    public Owner(int ownerId) {
        this.ownerId = ownerId;
        this.age = 0;
        this.name = "";
        this.lastName = "";
    }

    public void getInfo() {
        System.out.printf("name : %s \t lastName : %s \t " +
                "age : %d \t ownerId : %d \n",
                this.name, this.lastName, this.age, this.ownerId);
    }

    public String getName() {
        return this.name;
    }

    public  String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        Owner owner = (Owner) object;
        return ownerId == owner.ownerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId);
    }

    public boolean EqualOwner(Owner owner1, Owner owner2) {
        if ((owner1.getName().equals(owner2.getName()) & (owner1.getLastName().equals(owner2.getLastName())) & (owner1.getAge() == owner2.getAge())) & (owner1.getOwnerId() == owner2.getOwnerId())) {
            return true;
        } else return false;
    }

}

