package com.bawie.movie.view.fragment;

import android.view.View;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.HotMovieBean;
import com.bawie.movie.presenter.HomePresenter;
import com.bawie.movie.view.adapter.MyAdapter1;
import com.bawie.movie.view.interfaces.IHomeView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentHot extends BaseFragment<HomePresenter> implements IHomeView.IBase {
    private RecyclerView recyclerview_hot;

    @Override
    void initData() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview_hot.setLayoutManager(layoutManager);
        f.load(this);
    }

    @Override
    HomePresenter setFragment() {
        return new HomePresenter();
    }

    @Override
    void initView() {
        recyclerview_hot = inflate.findViewById(R.id.recyclerview_hot);
    }

    @Override
    int initLayout() {
        return R.layout.fraghot;
    }

    @Override
    public void ok(HotMovieBean hotMovieBean) {

        MyAdapter1 myAdapter1 = new MyAdapter1(hotMovieBean.getResult(), getContext());
        recyclerview_hot.setAdapter(myAdapter1);
    }
}
