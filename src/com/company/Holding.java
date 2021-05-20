package com.company;

public class Holding {
    public String name;
    public String clientType;
    public boolean isSanctioned;
    public int inn;
    public boolean isBiggest;
    public String s;

    public Holding(String name, String clientType, boolean isSanctioned, boolean isBiggest, int inn) {
        this.clientType = clientType;
        this.inn = inn;
        this.isSanctioned = isSanctioned;
        this.name = name;
        this.isBiggest = isBiggest;
    }
    public String getInfo() {
        s = "name : " + this.name + " clientType : " + this.clientType + " inn : " + this.inn
                + " isSanctioned : " + this.isSanctioned + " isBiggest : " + this.isBiggest;
        return s;
    }
}
