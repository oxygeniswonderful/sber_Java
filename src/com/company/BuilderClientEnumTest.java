package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderClientEnumTest {

    @Test
    void buildClient() {
        String file1 = "/Users/admin/Desktop/Java/LEGAL_ENTITY.json";
        String file2 = "/Users/admin/Desktop/Java/HOLDING.json";
        String file3 = "/Users/admin/Desktop/Java/INDIVIDUAL.json";
        BuilderClientEnum builderClientEnum1 = new BuilderClientEnum(file1);
        BuilderClientEnum builderClientEnum2 = new BuilderClientEnum(file2);
        BuilderClientEnum builderClientEnum3 = new BuilderClientEnum(file3);
        assertEquals(1172131546, builderClientEnum1.buildClient());
        assertEquals(266272063, builderClientEnum2.buildClient());
        assertEquals(172032696, builderClientEnum3.buildClient());
    }
}