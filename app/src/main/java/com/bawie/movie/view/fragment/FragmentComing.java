package com.bawie.movie.view.fragment;

import android.view.View;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.ComingMovieBean;
import com.bawie.movie.presenter.HomePresenter;
import com.bawie.movie.view.adapter.MyAdapter2;
import com.bawie.movie.view.interfaces.IHomeView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentComing extends BaseFragment<HomePresenter> implements IHomeView.IComint {

    private RecyclerView recyclerview_com;

    @Override
    void initData() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview_com.setLayoutManager(layoutManager);
        f.shang(this);
    }

    @Override
    HomePresenter setFragment() {
        return new HomePresenter();
    }

    @Override
    void initView() {
        recyclerview_com = inflate.findViewById(R.id.recyclerview_com);
    }

    @Override
    int initLayout() {
        return R.layout.fragcom;
    }

    @Override
    public void comint(ComingMovieBean comingMovieBean) {
        final MyAdapter2 myAdapter2 = new MyAdapter2(comingMovieBean.getResult(), getContext());
        recyclerview_com.setAdapter(myAdapter2);
    }
}
