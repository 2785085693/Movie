package com.bawie.movie.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawie.movie.presenter.BasePresenter;
import com.bawie.movie.view.activity.BaseActivity;
import com.bawie.movie.view.interfaces.IBaseView;
import com.bawie.movie.view.interfaces.IHomeView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<F extends BasePresenter> extends Fragment implements IBaseView {

    public View inflate;
    public F f;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = LayoutInflater.from(getContext()).inflate(initLayout(), container, false);

        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        f = setFragment();
        f.attach(this);
        initData();
    }

    abstract void initData();

    abstract F setFragment();
    abstract void initView();

    abstract int initLayout();

}
