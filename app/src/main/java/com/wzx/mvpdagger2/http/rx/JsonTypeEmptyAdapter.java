package com.wzx.mvpdagger2.http.rx;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;


public class JsonTypeEmptyAdapter implements JsonSerializer<String>, JsonDeserializer<String> {
    @Override
    public JsonElement serialize(String src, Type typeOfSrc,
                                 JsonSerializationContext context) {
        if (src == null) {
            Log.e("msg", "null");
            return new JsonPrimitive("");
        } else {
            return new JsonPrimitive(src.toString());
        }
    }

    @Override
    public String deserialize(JsonElement json, Type typeOfT,
                              JsonDeserializationContext context)
            throws JsonParseException {
        Log.e("msg", json.getAsJsonPrimitive().getAsString());
        return json.getAsJsonPrimitive().getAsString();
    }
}
