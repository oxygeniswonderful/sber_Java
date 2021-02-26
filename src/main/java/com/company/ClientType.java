package com.company;

import com.google.gson.Gson;
import java.io.Reader;

public enum ClientType {
    HOLDING {
        public Object create_client(Gson gson, Reader reader) {
            return gson.fromJson(reader, HOLDING.class);
        }
    },
    LEGAL_ENTITY {
        public Object create_client(Gson gson, Reader reader) {
            return gson.fromJson(reader, LEGAL_ENTITY.class);
        }
    },
    INDIVIDUAL {
        public Object create_client(Gson gson, Reader reader) {
            return gson.fromJson(reader, INDIVIDUAL.class);
        }
    };
    public  abstract Object create_client(Gson gson, Reader reader);
}
