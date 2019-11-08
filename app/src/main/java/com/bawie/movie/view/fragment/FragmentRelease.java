package com.bawie.movie.view.fragment;

import android.view.View;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.ReleaseMovieBean;
import com.bawie.movie.presenter.HomePresenter;
import com.bawie.movie.view.adapter.MyAdapter;
import com.bawie.movie.view.interfaces.IHomeView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentRelease extends BaseFragment<HomePresenter> implements IHomeView.IRelease {
    private RecyclerView recyclerview_rel;

    @Override
    void initData() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview_rel.setLayoutManager(layoutManager);
        f.zheng(this);
    }

    @Override
    HomePresenter setFragment() {
        return new HomePresenter();
    }

    @Override
    void initView() {
        recyclerview_rel = inflate.findViewById(R.id.recyclerview_rel);
    }

    @Override
    int initLayout() {
        return R.layout.fragrel;
    }

    @Override
    public void releas(ReleaseMovieBean releaseMovieBean) {
        final MyAdapter myAdapter = new MyAdapter(releaseMovieBean.getResult(), getContext());
        recyclerview_rel.setAdapter(myAdapter);
    }
}
