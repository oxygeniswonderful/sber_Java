package com.company;

public class Individual {

    public String name;
    public String surname;
    public int inn;
    public String clientType;
    public String email;
    public String s;
    public Individual(String name, String surname, int inn, String clientType, String email) {
        this.clientType = clientType;
        this.inn = inn;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public String getInfo() {
        s = "name : " + this.name + " surname : " + this.surname + " clientType : " + this.clientType + " inn : " + this.inn
                + " email : " + this.email;
        return s;
    }
}
