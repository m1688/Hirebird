package com.recruit.app.util;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;

/**
 * jyu - 1/5/14.
 */
public class JsonUtils {

    private static Gson gson = new Gson();

    public static <T> T readModel(Context context, String fileName, String xpath, Class<T> clazz){
        InputStream is = null;
        try {
            is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String bufferString = new String(buffer);
            JsonParser parser = new JsonParser();
            JsonElement json = parser.parse(bufferString);
            return gson.fromJson(json.getAsJsonObject().get(xpath),clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
