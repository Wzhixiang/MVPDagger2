package com.wzx.mvpdagger2.base;

import android.app.Application;

import com.wzx.mvpdagger2.di.component.ApplicationComponent;
import com.wzx.mvpdagger2.di.component.DaggerApplicationComponent;
import com.wzx.mvpdagger2.di.module.ApplicationModule;

/**
 * 描述 TODO
 * Created by Administrator on 2017/11/3.
s */

public class App extends Application {

    private static App mApp;
    private ApplicationComponent mApplicationComponent;

    public static App getContext() {
        return mApp;
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        initApplicationComponent();
    }

    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
    }
}
