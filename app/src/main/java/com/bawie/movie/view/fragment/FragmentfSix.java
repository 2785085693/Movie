package com.bawie.movie.view.fragment;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.DetailsBean;
import com.bawie.movie.presenter.HomePresenter;
import com.bawie.movie.view.adapter.DetailsAdapter3;
import com.bawie.movie.view.interfaces.IHomeView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class FragmentfSix extends BaseFragment<HomePresenter> implements IHomeView.IDeta {


    private RecyclerView six_recyclerview;

    @Override
    void initData() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        six_recyclerview.setLayoutManager(gridLayoutManager);
        f.detas(this);
    }

    @Override
    HomePresenter setFragment() {
        return new HomePresenter();
    }

    @Override
    void initView() {
        six_recyclerview = inflate.findViewById(R.id.six_recyclerview);


    }

    @Override
    int initLayout() {
        return R.layout.fragsix;
    }

    @Override
    public void deta(DetailsBean detailsBean) {
        DetailsAdapter3 detailsAdapter3 = new DetailsAdapter3(detailsBean.getResult().getShortFilmList(), getContext());
        six_recyclerview.setAdapter(detailsAdapter3);
    }
}


