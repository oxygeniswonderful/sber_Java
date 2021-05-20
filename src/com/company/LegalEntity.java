package com.company;

 public class LegalEntity {

    public String name;
    public int inn;
    public String clientType;
    public boolean isSanctioned;
    String s;

    public LegalEntity(String name, int inn, String clientType, boolean isSanctioned) {
    this.name = name;
    this.inn = inn;
    this.clientType = clientType;
    this.isSanctioned = isSanctioned;
    }

    public String getInfo() {
       s = "name : " + this.name + " clientType : " + this.clientType + " inn : " + this.inn
       + " isSanctioned : " + this.isSanctioned;
       return s;
    }
}
