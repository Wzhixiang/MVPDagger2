package com.wzx.mvpdagger2.mvp.ui.contract;

import com.wzx.mvpdagger2.base.interfaces.BasePresenter;
import com.wzx.mvpdagger2.base.interfaces.BaseView;
import com.wzx.mvpdagger2.bean.Future24;

import java.util.List;

/**
 * 描述 TODO
 * Created by Administrator on 2017/11/3.
 * 公司名称 广州安腾网络科技有限公司
 */

public interface MainContract {

    interface View extends BaseView{
        void showResult(List<Future24> list);
    }

    interface Preseneter extends BasePresenter<View> {
        void requestText();
        void requestWeather();
    }
}
