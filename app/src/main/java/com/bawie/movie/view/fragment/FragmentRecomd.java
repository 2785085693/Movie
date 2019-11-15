package com.bawie.movie.view.fragment;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.CinemaBean;
import com.bawie.movie.model.bean.RecomBean;
import com.bawie.movie.model.bean.RegionBean;
import com.bawie.movie.presenter.HomePresenter;
import com.bawie.movie.view.adapter.CinemaAdapter;
import com.bawie.movie.view.adapter.RegionAdapter;
import com.bawie.movie.view.interfaces.IHomeView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentRecomd extends BaseFragment<HomePresenter> implements IHomeView.IRegiog,IHomeView.ICinema {
    private RecyclerView recom2_recyclerview;
    private RecyclerView recom2_recyclerview1;

    @Override
    void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recom2_recyclerview.setLayoutManager(layoutManager);
        f.iregion(this);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(RecyclerView.VERTICAL);
        recom2_recyclerview1.setLayoutManager(layoutManager1);
        f.icinema(this);
    }

    @Override
    HomePresenter setFragment() {
        return new HomePresenter();
    }

    @Override
    void initView() {
        recom2_recyclerview = inflate.findViewById(R.id.recom2_recyclerview);
        recom2_recyclerview1 = inflate.findViewById(R.id.recom2_recyclerview1);
    }

    @Override
    int initLayout() {
        return R.layout.recom2;
    }


    @Override
    public void iregi(RegionBean regionBean) {
        RegionAdapter regionAdapter = new RegionAdapter(regionBean.getResult(), getContext());
        recom2_recyclerview.setAdapter(regionAdapter);
    }

    @Override
    public void cinem(CinemaBean cinemaBean) {
        CinemaAdapter cinemaAdapter = new CinemaAdapter(cinemaBean.getResult(), getContext());
        recom2_recyclerview1.setAdapter(cinemaAdapter);

    }
}
