package com.bawie.movie.view.fragment;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.RecomBean;
import com.bawie.movie.presenter.HomePresenter;
import com.bawie.movie.view.interfaces.IHomeView;

public class FragmentRecomd extends BaseFragment<HomePresenter> implements IHomeView.IRecom {
    @Override
    void initData() {

    }

    @Override
    HomePresenter setFragment() {
        return new HomePresenter();
    }

    @Override
    void initView() {

    }

    @Override
    int initLayout() {
        return R.layout.recom2;
    }

    @Override
    public void recom(RecomBean recomBean) {

    }
}
