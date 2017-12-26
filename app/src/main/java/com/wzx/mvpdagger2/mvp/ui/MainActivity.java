package com.wzx.mvpdagger2.mvp.ui;

import android.widget.TextView;
import android.widget.Toast;

import com.wzx.mvpdagger2.R;
import com.wzx.mvpdagger2.base.BaseActivity;
import com.wzx.mvpdagger2.bean.Future24;
import com.wzx.mvpdagger2.mvp.ui.contract.MainContract;
import com.wzx.mvpdagger2.mvp.ui.presenter.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class MainActivity extends BaseActivity<MainContract.Preseneter> implements MainContract.View {

    @BindView(R.id.tv_result)
    TextView mTextView;

    @OnClick(R.id.tv_result)
    void onTextClick() {
        mMainPresenter.requestText();
    }

    @Inject
    MainPresenter mMainPresenter;

    @Override
    public int setLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected MainContract.Preseneter initInjection() {
        mActivityComponent.inject(this);
        return mMainPresenter;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews(boolean isRefresh) {
        mMainPresenter.requestWeather();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNetError() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finishRefresh() {

    }

    @Override
    public void onLogin() {

    }


    @Override
    public void showResult(List<Future24> list) {
        mTextView.setText(list == null ? "0" : "" + list.size());
    }
}
