package com.company;

public class INDIVIDUAL {

    public String name;
    public String surname;
    public int inn;
    public String clientType;
    public String email;

    public INDIVIDUAL() {
    }
    public INDIVIDUAL(String name, String surname, int inn, String clientType, String email) {
        this.clientType = clientType;
        this.inn = inn;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
