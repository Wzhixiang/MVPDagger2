package com.wzx.mvpdagger2.http.rx;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 数据格式转换
 *
 * @param <T>
 */
public class ResultTransform<T> implements ObservableTransformer<BaseResult<T>, T> {

    @Override
    public ObservableSource<T> apply(Observable<BaseResult<T>> upstream) {
        return upstream.map(new Function<BaseResult<T>, T>() {
            @Override
            public T apply(BaseResult<T> tBaseResult) throws Exception {
                if (tBaseResult.isSuccess()) {
                    return tBaseResult.getData();
                } else {
                    throw new RuntimeException(tBaseResult.getMsg());
                }
            }
        })
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
