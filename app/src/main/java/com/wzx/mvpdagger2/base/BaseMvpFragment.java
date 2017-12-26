package com.wzx.mvpdagger2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wzx.mvpdagger2.base.interfaces.BasePresenter;
import com.wzx.mvpdagger2.base.interfaces.BaseView;
import com.wzx.mvpdagger2.di.component.DaggerFragmentComponent;
import com.wzx.mvpdagger2.di.component.FragmentComponent;
import com.wzx.mvpdagger2.di.module.FragmentModule;

import butterknife.ButterKnife;

/**
 *
 * Created by Administrator on 2017/3/20.
 */
public abstract class BaseMvpFragment<T extends BasePresenter> extends Fragment implements BaseView {

    protected T mPresenter;

    protected FragmentComponent mFragmentComponent;

    private View mRootView;

    private AppCommont mAppContext;

    protected abstract int getLayoutRes();

    protected abstract T initInjection();

    protected abstract void initViews();

    protected abstract void updateViews(boolean isRefresh);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFragmentComponent = DaggerFragmentComponent.builder().
                applicationComponent((App.getContext()).getApplicationComponent()).
                fragmentModule(new FragmentModule(this)).build();

        mPresenter = initInjection();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutRes(), null);
            ButterKnife.bind(this, mRootView);
            initViews();
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mRootView != null) {
            updateViews(false);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }
}
