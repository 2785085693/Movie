package com.bawie.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.DetailsBean;
import com.bawie.movie.model.bean.HotMovieBean;
import com.bawie.movie.presenter.HomePresenter;
import com.bawie.movie.view.adapter.BootAdapter;
import com.bawie.movie.view.adapter.FragAdapter;
import com.bawie.movie.view.fragment.FragmentOne;
import com.bawie.movie.view.fragment.FragmentThree;
import com.bawie.movie.view.fragment.FragmentTwo;
import com.bawie.movie.view.fragment.FragmentfFive;
import com.bawie.movie.view.fragment.FragmentfFore;
import com.bawie.movie.view.fragment.FragmentfSeven;
import com.bawie.movie.view.fragment.FragmentfSix;
import com.bawie.movie.view.interfaces.IHomeView;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class ShowActivity extends BaseActivity<HomePresenter> implements IHomeView.IDeta {


    private ImageView boot_ImageView;
    private TextView fen;
    private TextView textView_fen;
    private TextView lun;
    private TextView tiao;
    private TabLayout boot_TabLayout;
    private ViewPager boot_ViewPager;
    private RecyclerView recyclerview_boot;

    private List<Fragment> list;
    private FragAdapter fragAdapter;
    private RadioButton filmreview;
    private String movieId;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String name1 = intent.getExtras().getString("name1");
        String name2 = intent.getExtras().getString("name2");
        movieId = intent.getStringExtra("movieId");

        fen.setText(name1);
        textView_fen.setText(name2);
        Glide.with(this).load(name).into(boot_ImageView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview_boot.setLayoutManager(layoutManager);
        p.detas(this);

    }

    @Override
    HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    void initView() {
        fen = findViewById(R.id.fen);
        textView_fen = findViewById(R.id.textView_fen);
        boot_ImageView = findViewById(R.id.boot_ImageView);
        boot_TabLayout = findViewById(R.id.boot_TabLayout);
        boot_ViewPager = findViewById(R.id.boot_ViewPager);
        recyclerview_boot = findViewById(R.id.recyclerview_boot);
        recyclerview_boot = findViewById(R.id.recyclerview_boot);
        filmreview = findViewById(R.id.filmreview);

        filmreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(ShowActivity.this, FilmreActivity.class);
                startActivity(intent);
            }
        });

        List<String> tab2=new ArrayList<>();
        tab2.add("介绍");
        tab2.add("预告");
        tab2.add("剧照");
        tab2.add("影评");

        boot_TabLayout.setupWithViewPager(boot_ViewPager);
        list = new ArrayList<>();
        list.add(new FragmentfFore());
        list.add(new FragmentfFive());
        list.add(new FragmentfSix());
        list.add(new FragmentfSeven());

        for (int i = 0; i <tab2.size() ; i++) {
            final String s = tab2.get(i);
            final TabLayout.Tab tab1 = this.boot_TabLayout.newTab();
            if (tab1!=null){
                tab1.setText(s);
                boot_TabLayout.addTab(tab1);
            }

        }

        fragAdapter = new FragAdapter(getSupportFragmentManager(), list, tab2);
        boot_ViewPager.setAdapter(fragAdapter);
    }

    @Override
    int initLayout() {
        return R.layout.bootpage;
    }

    @Override
    public void deta(DetailsBean detailsBean) {
        DetailsBean.ResultBean result = detailsBean.getResult();
        List<DetailsBean.ResultBean> list = new ArrayList<>();
        list.add(result);

        BootAdapter bootAdapter = new BootAdapter(list, this);
        recyclerview_boot.setAdapter(bootAdapter);
    }
}
