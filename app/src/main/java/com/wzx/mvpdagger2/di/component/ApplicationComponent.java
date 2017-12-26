package com.wzx.mvpdagger2.di.component;

import android.content.Context;

import com.wzx.mvpdagger2.base.App;
import com.wzx.mvpdagger2.base.AppCommont;
import com.wzx.mvpdagger2.di.module.ApplicationModule;
import com.wzx.mvpdagger2.di.scope.ContextLife;
import com.wzx.mvpdagger2.di.scope.PerApp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/3/19.
 */
@PerApp
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App app);

    @ContextLife("Application")
    Context getContext();

    AppCommont provideAppCommont();
}
