package com.bawie.movie.view.fragment;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.RecomBean;
import com.bawie.movie.presenter.HomePresenter;
import com.bawie.movie.view.adapter.RecomAdapter;
import com.bawie.movie.view.interfaces.IHomeView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentRecom extends BaseFragment<HomePresenter> implements IHomeView.IRecom {
    private RecyclerView recom_recyclerview;

    @Override
    void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recom_recyclerview.setLayoutManager(layoutManager);
        f.recoms(this);
    }

    @Override
    HomePresenter setFragment() {
        return new HomePresenter();
    }

    @Override
    void initView() {
        recom_recyclerview = inflate.findViewById(R.id.recom_recyclerview);
    }

    @Override
    int initLayout() {
        return R.layout.recom;
    }

    @Override
    public void recom(RecomBean recomBean) {
        RecomAdapter recomAdapter = new RecomAdapter(getActivity(), recomBean.getResult());
        recom_recyclerview.setAdapter(recomAdapter);
    }
}
