package com.company;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        System.out.println(file);

        try  {

            Gson gson = new Gson();

            Reader reader = Files.newBufferedReader(Paths.get(file));

            Map<?, ?> map = gson.fromJson(reader, Map.class);

            Object client = new Object();

            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (entry.getKey().equals("clientType")) {

                    Reader r = Files.newBufferedReader(Paths.get(file));
                    client = ClientType.valueOf((String) entry.getValue()).create_client(gson, r);
                    System.out.println(client);

                    reader.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
