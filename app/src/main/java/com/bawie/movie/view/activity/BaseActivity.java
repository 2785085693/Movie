package com.bawie.movie.view.activity;

import android.os.Bundle;

import com.bawie.movie.presenter.BasePresenter;
import com.bawie.movie.view.interfaces.IBaseView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        p = setPresenter();
        p.attach(this);
        initData();

    }

    abstract void initData();

    abstract P setPresenter();
    abstract void initView();

    abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.detach();
    }
}
