package com.company;

import static org.junit.jupiter.api.Assertions.*;

class BuilderClientWithIfTest {

    @org.junit.jupiter.api.Test
    void buildClient() {
        String s1, s2, s3;
        String file1 = "/Users/admin/Desktop/Java/LEGAL_ENTITY.json";
        String file2 = "/Users/admin/Desktop/Java/HOLDING.json";
        String file3 = "/Users/admin/Desktop/Java/INDIVIDUAL.json";
        BuilderClientWithIf builderClientWithIf1 = new BuilderClientWithIf(file1);
        BuilderClientWithIf builderClientWithIf2 = new BuilderClientWithIf(file2);
        BuilderClientWithIf builderClientWithIf3 = new BuilderClientWithIf(file3);
        s1 = "name : ООО Матрешка clientType : LEGAL_ENTITY inn : 13242352 isSanctioned : true";
        s2 = "name : David clientType : HOLDING inn : 123 isSanctioned : false isBiggest : false";
        s3 = "name : Julia surname : Smith clientType : INDIVIDUAL inn : 3443 email : funny_games@mail.ru";
        assertEquals(builderClientWithIf1.buildClient(), s1);
        assertEquals(builderClientWithIf2.buildClient(), s2);
        assertEquals(builderClientWithIf3.buildClient(), s3);
    }
}