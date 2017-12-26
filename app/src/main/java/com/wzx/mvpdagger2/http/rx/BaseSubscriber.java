package com.wzx.mvpdagger2.http.rx;

import android.widget.Toast;

import com.wzx.mvpdagger2.base.App;
import com.wzx.mvpdagger2.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BaseSubscriber<T> implements Observer<T> {

    public static final String SERVERFAIL = "哎呀,服务器内部开小差了丫^_^";

    protected boolean hasNetWork() {
        if (!NetUtils.isNetWorkConnectted()) {
            Toast.makeText(App.getContext(), "请连接网络或稍后重试...", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onError(Throwable e) {
        throw new RuntimeException(SERVERFAIL);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        if (!hasNetWork()) {
            //无网络
        }
    }

    @Override
    public void onNext(T t) {

    }
}
