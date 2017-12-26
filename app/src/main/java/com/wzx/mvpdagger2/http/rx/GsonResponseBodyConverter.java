package com.wzx.mvpdagger2.http.rx;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Administrator on 2017/6/6.
 */
public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    public GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {

        String response = value.string();
        Log.d("GsonResponse", response);
        ServerResponse serverResponse;
        try {
            /*先将返回的json数据解析到ServerResponse中，
            如果code==200，则解析到我们的实体基类中，否则抛异常*/
            serverResponse = gson.fromJson(response, ServerResponse.class);//无奈
        } catch (Exception e) {
            serverResponse = new ServerResponse("0", "服务器异常");
        }

        if (serverResponse.isSuccess("OK")) {
            Log.d("GsonResponse", "successful");
            return gson.fromJson(response, type);
        } else {
            throw new RuntimeException(serverResponse.getMsg());
        }
    }
}