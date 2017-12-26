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

/**
 * Created by Administrator on 2017/6/8.
 */

public class JsonTypeEmptyAdapter implements JsonSerializer<String>, JsonDeserializer<String> {
    //    @Override
//    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//        try {
//            Log.e("msg", json.getAsString());
//            if (json.getAsString().equals("\"\"") || json.getAsString().equals("null")
//                    || json.getAsString().equals("NULL")) {//应对后台不规范的json,哭了
//                return "{}";
//            }
//        } catch (Exception ignore) {
//        }
//        try {
//            return json.getAsString();
//        } catch (NumberFormatException e) {
//            throw new JsonSyntaxException(e);
//        }
//    }
//
//    @Override
//    public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
//        return new JsonPrimitive(src);
//    }
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
