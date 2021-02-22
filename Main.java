package com.company;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        System.out.println(file);

         try {
            Gson gson = new Gson();

            Reader reader = Files.newBufferedReader(Paths.get(file));

            Map<?, ?> map = gson.fromJson(reader, Map.class);

            for (Map.Entry<?, ?> entry : map.entrySet()) {

                if(entry.getKey().equals("clientType") && entry.getValue().equals("LEGAL_ENTITY")) {

                    Reader r = Files.newBufferedReader(Paths.get(file));
                    LEGAL_ENTITY legal = gson.fromJson(r, LEGAL_ENTITY.class);
                    System.out.println(legal);
                }
                if(entry.getKey().equals("clientType") && entry.getValue().equals("HOLDING")) {

                    Reader r = Files.newBufferedReader(Paths.get(file));
                    HOLDING holding = gson.fromJson(r, HOLDING.class);
                    System.out.println(holding);

                }
                if(entry.getKey().equals("clientType") && entry.getValue().equals("INDIVIDUAL")) {

                    Reader r = Files.newBufferedReader(Paths.get(file));
                    INDIVIDUAL individual = gson.fromJson(r, INDIVIDUAL.class);
                    System.out.println(individual);

                }

            }

            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
