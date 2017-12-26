package com.wzx.mvpdagger2.base;

import android.support.annotation.NonNull;

import com.wzx.mvpdagger2.base.interfaces.BasePresenter;
import com.wzx.mvpdagger2.base.interfaces.BaseView;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Administrator on 2017/3/20.
 */
public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    protected T view;
    private CompositeDisposable mCompositeSubscription;

    public BasePresenterImpl() {
        mCompositeSubscription = new CompositeDisposable ();
    }

    @Override
    public void attachView(@NonNull T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void addSubscription(CompositeDisposable  subscription) {
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void unSubscribe() {
        mCompositeSubscription.clear();
    }
}
