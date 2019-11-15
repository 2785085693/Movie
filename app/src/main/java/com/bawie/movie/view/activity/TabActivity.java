package com.bawie.movie.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bawie.movie.R;
import com.bawie.movie.presenter.BasePresenter;
import com.bawie.movie.view.fragment.FragmentOne;
import com.bawie.movie.view.fragment.FragmentThree;
import com.bawie.movie.view.fragment.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class TabActivity extends BaseActivity implements View.OnClickListener{


    private ViewPager pager;
    private List<Fragment> list = new ArrayList<>();
    private ImageView imageMoveiDj;
    private LinearLayout linMovei;
    private LinearLayout layOne;
    private ImageView imageCinemDj;
    private LinearLayout linCinem;
    private LinearLayout layTwo;
    private ImageView imageMyyDj;
    private LinearLayout linMyy;
    private LinearLayout laySwe;
    //private RadioGroup group_tab;

    @Override
    void initData() {

    }

    @Override
    BasePresenter setPresenter() {
        return new BasePresenter();
    }

    @Override
    void initView() {

        //  group_tab = findViewById(R.id.group_tab);
        pager = findViewById(R.id.pager);
        imageMoveiDj = findViewById(R.id.image_movei_dj);
        linMovei  = findViewById(R.id.lin_movei);
        layOne = findViewById(R.id.lay_one);
        imageCinemDj = findViewById(R.id.image_cinem_dj);
        linCinem  = findViewById(R.id.lin_cinem);
        layTwo = findViewById(R.id.lay_two);
        imageMyyDj = findViewById(R.id.image_myy_dj);
        linMyy = findViewById(R.id.lin_myy);
        laySwe = findViewById(R.id.lay_swe);


        FragmentOne fragmentOne = new FragmentOne();
        FragmentTwo fragmentTwo = new FragmentTwo();
        FragmentThree fragmentThree = new FragmentThree();

        list.add(fragmentOne);
        list.add(fragmentTwo);
        list.add(fragmentThree);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        imageMoveiDj.setOnClickListener(this);
        imageCinemDj.setOnClickListener(this);
        imageMyyDj.setOnClickListener(this);
    }

    @Override
    int initLayout() {
        return R.layout.tablayout_main;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_movei_dj:
                imageMoveiDj.setVisibility(View.GONE);
                imageCinemDj.setVisibility(View.VISIBLE);
                imageMyyDj.setVisibility(View.VISIBLE);
                linMovei.setVisibility(View.VISIBLE);
                linCinem.setVisibility(View.GONE);
                linMyy.setVisibility(View.GONE);
                pager.setCurrentItem(0);
                break;
            case R.id.image_cinem_dj:
                imageMoveiDj.setVisibility(View.VISIBLE);
                imageCinemDj.setVisibility(View.GONE);
                imageMyyDj.setVisibility(View.VISIBLE);
                linMovei.setVisibility(View.GONE);
                linCinem.setVisibility(View.VISIBLE);
                linMyy.setVisibility(View.GONE);
                pager.setCurrentItem(1);
                break;
            case R.id.image_myy_dj:
                imageMoveiDj.setVisibility(View.VISIBLE);
                imageCinemDj.setVisibility(View.VISIBLE);
                imageMyyDj.setVisibility(View.GONE);
                linMovei.setVisibility(View.GONE);
                linCinem.setVisibility(View.GONE);
                linMyy.setVisibility(View.VISIBLE);
                pager.setCurrentItem(2);
                break;
        }
    }

}
