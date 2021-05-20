package com.company;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class BuilderClientWithIf {
    String file;

    public BuilderClientWithIf(String file) {
        this.file = file;
    }

    public String buildClient(){
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(this.file));
            Map<?, ?> map = gson.fromJson(reader, Map.class);
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if(entry.getKey().equals("clientType") && entry.getValue().equals("LEGAL_ENTITY")) {
                    Reader r = Files.newBufferedReader(Paths.get(this.file));
                    LegalEntity legal = gson.fromJson(r, LegalEntity.class);
                    return legal.getInfo();
                }
                if(entry.getKey().equals("clientType") && entry.getValue().equals("HOLDING")) {
                    Reader r = Files.newBufferedReader(Paths.get(this.file));
                    Holding holding = gson.fromJson(r, Holding.class);
                    return holding.getInfo();
                }
                if(entry.getKey().equals("clientType") && entry.getValue().equals("INDIVIDUAL")) {
                    Reader r = Files.newBufferedReader(Paths.get(this.file));
                    Individual individual = gson.fromJson(r, Individual.class);
                    return individual.getInfo();
                }
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
}

