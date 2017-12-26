package com.wzx.mvpdagger2.mvp.ui.presenter;

import android.support.annotation.NonNull;

import com.wzx.mvpdagger2.base.AppCommont;
import com.wzx.mvpdagger2.base.BasePresenterImpl;
import com.wzx.mvpdagger2.bean.Future24;
import com.wzx.mvpdagger2.http.RetrofitManager;
import com.wzx.mvpdagger2.http.rx.BaseSubscriber;
import com.wzx.mvpdagger2.http.rx.ResultTransform;
import com.wzx.mvpdagger2.mvp.ui.contract.MainContract;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * 描述 TODO
 * Created by Administrator on 2017/11/3.
 * 公司名称 广州安腾网络科技有限公司
 */

public class MainPresenter extends BasePresenterImpl<MainContract.View>
        implements MainContract.Preseneter {

    private AppCommont appCommont;

    public MainPresenter(@NonNull AppCommont appCommont) {
        this.appCommont = appCommont;
    }


    @Override
    public void requestText() {
        view.showToast("Click view");
    }

    @Override
    public void requestWeather() {
        RetrofitManager.getInstance().getTestApi().weatherAboutFuture24h("CHSH000000")
                .compose(new ResultTransform<List<Future24>>())
                .subscribe(new Future24Subscriber());
    }

    private class Future24Subscriber extends BaseSubscriber<List<Future24>> {

        @Override
        public void onError(Throwable e) {
            view.showToast(e.getMessage());
        }

        @Override
        public void onComplete() {

        }

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<Future24> list) {
            view.showResult(list);
        }
    }

}
