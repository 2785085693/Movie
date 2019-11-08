package com.bawie.movie.view.fragment;

import android.view.View;

import com.bawie.movie.R;
import com.bawie.movie.presenter.BasePresenter;

public class FragmentTwo extends BaseFragment{
    @Override
    void initData() {

    }

    @Override
    BasePresenter setFragment() {
        return new BasePresenter();
    }

    @Override
    void initView() {

    }

    @Override
    int initLayout() {
        return R.layout.fragtwo;
    }
}
