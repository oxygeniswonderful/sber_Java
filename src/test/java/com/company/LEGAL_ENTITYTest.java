package com.company;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class LEGAL_ENTITYTest {

    @Test
    void displayInfo() throws Exception{
        Gson gson = new Gson();
        Reader r = Files.newBufferedReader(Paths.get("/Users/admin/Desktop/Java/LEGAL_ENTITY.json"));
        LEGAL_ENTITY legal_entity = gson.fromJson(r, LEGAL_ENTITY.class);
        String expected = "{"
                + "name=ООО Матрешка," + "\n"
                + "inn=13242352," + "\n"
                + "clientType=LEGAL_ENTITY," + "\n"
                + "isSanctioned=true" + "\n}";
        String actual = legal_entity.DisplayInfo();
        assertEquals(expected, actual);
        r.close();
    }
}