package com.wzx.mvpdagger2.di.module;

import android.content.Context;

import com.wzx.mvpdagger2.base.AppCommont;
import com.wzx.mvpdagger2.di.scope.ContextLife;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/3/19.
 */
@Module
public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @ContextLife("Application")
    @Singleton
    Context provideApplicationContext() {
        return mContext;
    }

    @Provides
    @Singleton
    AppCommont providesAppContext() {
        return new AppCommont(mContext);
    }


}
