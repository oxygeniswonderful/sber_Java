package com.company;

public class HOLDING {
    public String name;
    public String clientType;
    public boolean isSanctioned;
    public int inn;
    public boolean isBiggest;

    public HOLDING() {
    }
    public HOLDING(String name, String clientType, boolean isSanctioned, boolean isBiggest, int inn) {
        this.clientType = clientType;
        this.inn = inn;
        this.isSanctioned = isSanctioned;
        this.name = name;
        this.isBiggest = isBiggest;
    }
}
