package dev.ua.uaproject.catwalk.common.utils.json;

import com.google.gson.Gson;

public class GsonSingleton {

    private static Gson instance;

    private GsonSingleton() {
    }

    public static Gson getInstance() {
        if (instance == null) {
            instance = new Gson();
        }

        return instance;
    }
}
