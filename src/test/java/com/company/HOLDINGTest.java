package com.company;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class HOLDINGTest {

    @Test
    void displayInfo() throws Exception{
            Gson gson = new Gson();
            Reader r = Files.newBufferedReader(Paths.get("/Users/admin/Desktop/Java/HOLDING.json"));
            HOLDING holding = gson.fromJson(r, HOLDING.class);
            String expected = "{"
                    + "name=David," + "\n"
                    + "clientType=HOLDING," + "\n"
                    + "isSanctioned=false," + "\n"
                    + "inn=123," + "\n"
                    +"isBiggest=false" + "\n}";
            String actual = holding.DisplayInfo();
            assertEquals(expected, actual);
            r.close();
    }
}