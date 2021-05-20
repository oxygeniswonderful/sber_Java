package com.company;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class BuilderClientEnum {
    String file;

    public BuilderClientEnum(String file) {
        this.file = file;
    }

    public int buildClient(){
        try  {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(this.file));
            Map<?, ?> map = gson.fromJson(reader, Map.class);
            Object client = new Object();
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (entry.getKey().equals("clientType")) {
                    Reader r = Files.newBufferedReader(Paths.get(this.file));
                    client = ClientType.valueOf((String) entry.getValue()).createСlient(gson, r);
                    reader.close();
                    return client.hashCode();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
