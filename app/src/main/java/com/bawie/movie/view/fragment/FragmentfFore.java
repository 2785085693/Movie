package com.bawie.movie.view.fragment;

import com.bawie.movie.R;
import com.bawie.movie.presenter.BasePresenter;

public class FragmentfFore extends BaseFragment{
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
        return R.layout.fragfore;
    }
}
