package controller;

import com.google.gson.Gson;

public class utils {
    public static <T> String provideJson(T t){
        Gson g = new Gson();
        String json = g.toJson(t);
        return json;
    }
}
