/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.wzx.mvpdagger2.di.module;

import android.app.Activity;
import android.content.Context;

import com.wzx.mvpdagger2.base.AppCommont;
import com.wzx.mvpdagger2.di.scope.ContextLife;
import com.wzx.mvpdagger2.di.scope.PerActivity;
import com.wzx.mvpdagger2.mvp.ui.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/3/19.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    @ContextLife("Activity")
    Context ProvideActivityContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    Activity ProvideActivity() {
        return mActivity;
    }


    @Provides
    @PerActivity
    MainPresenter ProvideLoginPresenter(AppCommont appCommont) {
        return new MainPresenter(appCommont);
    }
}
