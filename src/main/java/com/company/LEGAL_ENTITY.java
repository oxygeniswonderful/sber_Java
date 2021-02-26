package com.company;

public class LEGAL_ENTITY {

    public String name;
    public int inn;
    public String clientType;
    public boolean isSanctioned;

    public LEGAL_ENTITY() {
    }

    public LEGAL_ENTITY(String name, int inn, String clientType, boolean isSanctioned) {
        this.name = name;
        this.inn = inn;
        this.clientType = clientType;
        this.isSanctioned = isSanctioned;

    }
    public String DisplayInfo(){
        return "{"
                + "name=" + this.name + "," + "\n"
                + "inn=" + this.inn + "," + "\n"
                + "clientType=" + this.clientType + "," + "\n"
                + "isSanctioned=" + this.isSanctioned + "\n}";
    }
}
