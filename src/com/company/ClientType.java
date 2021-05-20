package com.company;

import com.google.gson.Gson;
import java.io.Reader;

enum ClientType {
    HOLDING {
        public Object createСlient(Gson gson, Reader reader) {
            return gson.fromJson(reader, Holding.class);
        }
    },
    LEGAL_ENTITY {
        public Object createСlient(Gson gson, Reader reader) {
            return gson.fromJson(reader, LegalEntity.class);
        }
    },
    INDIVIDUAL {
        public Object createСlient(Gson gson, Reader reader) {
            return gson.fromJson(reader, Individual.class);
        }
    };
    public  abstract Object createСlient(Gson gson, Reader reader);
}
