package com.bawie.movie.view.fragment;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.DetailsBean;
import com.bawie.movie.presenter.HomePresenter;
import com.bawie.movie.view.adapter.DetailsAdapter;
import com.bawie.movie.view.adapter.DetailsAdapter1;
import com.bawie.movie.view.adapter.DetailsAdapter2;
import com.bawie.movie.view.interfaces.IHomeView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentfFore extends BaseFragment<HomePresenter> implements IHomeView.IDeta {
    private RecyclerView foreitem_recyclerview;
    private RecyclerView perform_recyclerview;
    private RecyclerView fore_recyclerview;

    @Override
    void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        foreitem_recyclerview.setLayoutManager(layoutManager);
        f.detas(this);


        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(RecyclerView.HORIZONTAL);
        perform_recyclerview.setLayoutManager(layoutManager1);
        f.detas(this);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        layoutManager2.setOrientation(RecyclerView.VERTICAL);
        fore_recyclerview.setLayoutManager(layoutManager2);
        f.detas(this);


    }

    @Override
    HomePresenter setFragment() {
        return new HomePresenter();
    }

    @Override
    void initView() {
        foreitem_recyclerview = inflate.findViewById(R.id.foreitem_recyclerview);
        perform_recyclerview = inflate.findViewById(R.id.perform_recyclerview);
        fore_recyclerview = inflate.findViewById(R.id.fore_recyclerview);
    }

    @Override
    int initLayout() {
        return R.layout.fragfore;
    }

    @Override
    public void deta(DetailsBean detailsBean) {

        DetailsAdapter detailsAdapter = new DetailsAdapter(detailsBean.getResult().getMovieDirector(), getContext());
        foreitem_recyclerview.setAdapter(detailsAdapter);

        DetailsAdapter1 detailsAdapter1 = new DetailsAdapter1(detailsBean.getResult().getMovieActor(), getContext());
        perform_recyclerview.setAdapter(detailsAdapter1);

        final DetailsBean.ResultBean result = detailsBean.getResult();
        List<DetailsBean.ResultBean> list = new ArrayList<>();
        list.add(result);

        DetailsAdapter2 detailsAdapter2 = new DetailsAdapter2(list,getContext());
        fore_recyclerview.setAdapter(detailsAdapter2);

    }
}
