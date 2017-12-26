package com.wzx.mvpdagger2.http.api;

import com.wzx.mvpdagger2.bean.Future24;
import com.wzx.mvpdagger2.http.rx.BaseResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TestApi {

    @GET("Heart/index/future24h/")
    Observable<BaseResult<List<Future24>>> weatherAboutFuture24h(@Query("city") String cityCode);

}
