package com.bawie.movie.view.fragment;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.FindBean;
import com.bawie.movie.presenter.BasePresenter;
import com.bawie.movie.presenter.HomePresenter;
import com.bawie.movie.view.adapter.FindAdapter;
import com.bawie.movie.view.interfaces.IHomeView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentfSeven extends BaseFragment<HomePresenter> implements IHomeView.IFind {

    private RecyclerView recyclerview_seven;

    @Override
    void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview_seven.setLayoutManager(layoutManager);
        f.finds(this);

    }

    @Override
    HomePresenter setFragment() {
        return new HomePresenter();
    }

    @Override
    void initView() {
        recyclerview_seven = inflate.findViewById(R.id.recyclerview_seven);
    }

    @Override
    int initLayout() {
        return R.layout.fragseven;
    }

    @Override
    public void find(FindBean findBean) {
        FindAdapter findAdapter = new FindAdapter(findBean.getResult(), getContext());
        recyclerview_seven.setAdapter(findAdapter);
    }
}
