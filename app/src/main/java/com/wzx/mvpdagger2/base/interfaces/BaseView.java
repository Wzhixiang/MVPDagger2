package com.wzx.mvpdagger2.base.interfaces;

public interface BaseView {
    /**
     * 显示加载动画
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 显示网络错误
     */
    void showNetError();

    /**
     * 显示无数据
     */
    void showEmpty();
    /**
     * 弹出提示
     */
    void showToast(String msg);

    /**
     * 完成刷新, 新增控制刷新
     */
    void finishRefresh();

    /**
     * 没登录
     */
    void onLogin();
}
