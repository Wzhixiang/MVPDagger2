package com.wzx.mvpdagger2.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.wzx.mvpdagger2.R;
import com.wzx.mvpdagger2.base.interfaces.BasePresenter;
import com.wzx.mvpdagger2.base.interfaces.BaseView;
import com.wzx.mvpdagger2.di.component.ActivityComponent;
import com.wzx.mvpdagger2.di.component.DaggerActivityComponent;
import com.wzx.mvpdagger2.di.module.ActivityModule;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity
        implements BaseView {

    protected T mPresenter;
    protected ActivityComponent mActivityComponent;
    private static Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initState();//状态栏
        setContentView(setLayoutRes());

        ButterKnife.bind(this);

        attachInjector();

        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateViews(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }

    private void attachInjector() {

        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent((App.getContext()).getApplicationComponent())
                .activityModule(new ActivityModule(this)).build();

        mPresenter = initInjection();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }


    protected final Handler getHandler() {
        if (handler == null) {
            handler = new Handler(getMainLooper());
        }
        return handler;
    }

    protected void updateViews(boolean isRefresh) {

    }

    public abstract int setLayoutRes();

    protected abstract T initInjection();

    protected abstract void initViews();

    private void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

            /*1. View.SYSTEM_UI_FLAG_VISIBLE：显示状态栏，Activity不全屏显示(恢复到有状态栏的正常情况)。

            2. View.INVISIBLE：隐藏状态栏，同时Activity会伸展全屏显示。

            3. View.SYSTEM_UI_FLAG_FULLSCREEN：Activity全屏显示，且状态栏被隐藏覆盖掉。

            4. View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN：Activity全屏显示，但状态栏不会被隐藏覆盖，状态栏依然可见，Activity顶端布局部分会被状态遮住。

            5. View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION：效果同View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

            6. View.SYSTEM_UI_LAYOUT_FLAGS：效果同View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

            7. View.SYSTEM_UI_FLAG_HIDE_NAVIGATION：隐藏虚拟按键(导航栏)。有些手机会用虚拟按键来代替物理按键。

            8. View.SYSTEM_UI_FLAG_LOW_PROFILE：状态栏显示处于低能显示状态(low profile模式)，状态栏上一些图标显示会被隐藏。*/

            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    /*TODO 导航栏*/
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    /*TODO 状态栏*/
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            );
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);//将状态栏设置成透明
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimary));//导航栏
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

}
