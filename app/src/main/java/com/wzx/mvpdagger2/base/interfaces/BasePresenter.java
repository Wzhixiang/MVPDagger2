package com.wzx.mvpdagger2.base.interfaces;

import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;

public interface BasePresenter<T extends BaseView> {
    void attachView(@NonNull T view);

    void detachView();

    void addSubscription(CompositeDisposable subscription);

    void unSubscribe();
}
