package com.company;

import org.junit.jupiter.api.Test;
import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class INDIVIDUALTest {

    @Test
    void displayInfo()  throws Exception{
        Gson gson = new Gson();
        Reader r = Files.newBufferedReader(Paths.get("/Users/admin/Desktop/Java/INDIVIDUAL.json"));
        INDIVIDUAL individual = gson.fromJson(r, INDIVIDUAL.class);
        String expected = "{"
                + "name=Julia," + "\n"
                + "surname=Smith," + "\n"
                + "inn=3443," + "\n"
                + "clientType=INDIVIDUAL," + "\n"
                +"email=funny_games@mail.ru" + "\n}";
        String actual = individual.DisplayInfo();
        assertEquals(expected, actual);
        r.close();
    }
}