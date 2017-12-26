package com.wzx.mvpdagger2.base.interfaces;

import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Administrator on 2017/3/20.
 */
public interface BasePresenter<T extends BaseView> {
    void attachView(@NonNull T view);

    void detachView();

    void addSubscription(CompositeDisposable subscription);

    void unSubscribe();
}
