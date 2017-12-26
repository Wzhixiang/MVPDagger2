package com.wzx.mvpdagger2.http.api;

import com.wzx.mvpdagger2.bean.User;
import com.wzx.mvpdagger2.http.rx.BaseResult;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 描述 TODO
 * Created by Administrator on 2017/12/25.
 * 公司名称 广州安腾网络科技有限公司
 */

public interface TestApi {

    @FormUrlEncoded
    @POST("user/user_login")
    @Headers("Content-Type:application/x-www-form-urlencoded;charset=utf-8")
    Observable<BaseResult<User>> login(@Field("name") String phone,
                                       @Field("password") String password);

}
