package com.bawie.movie.view.activity;

import android.os.Bundle;

import com.bawie.movie.R;
import com.bawie.movie.presenter.BasePresenter;
import com.bawie.movie.view.adapter.FragAdapter;
import com.bawie.movie.view.fragment.FragmentComing;
import com.bawie.movie.view.fragment.FragmentHot;
import com.bawie.movie.view.fragment.FragmentOne;
import com.bawie.movie.view.fragment.FragmentRelease;
import com.bawie.movie.view.fragment.FragmentTwo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class TablistActivity extends BaseActivity {
    private TabLayout tabLayout_list;
    private ViewPager pager_list;
    private List<Fragment> list;
    private FragAdapter fragAdapter;
    @Override
    void initData() {

    }

    @Override
    BasePresenter setPresenter() {
        return new BasePresenter();
    }

    @Override
    void initView() {
        tabLayout_list = findViewById(R.id.tabLayout_list);
        pager_list = findViewById(R.id.pager_list);

        List<String> tab2=new ArrayList<>();
        tab2.add("正在热映");
        tab2.add("即将上映");
        tab2.add("热门电影");

        tabLayout_list.setupWithViewPager(pager_list);
        list = new ArrayList<>();
        list.add(new FragmentHot());
        list.add(new FragmentComing());
        list.add(new FragmentRelease());

        for (int i = 0; i <tab2.size() ; i++) {
            final String s = tab2.get(i);
            final TabLayout.Tab tab1 = this.tabLayout_list.newTab();
            if (tab1!=null){
                tab1.setText(s);
                tabLayout_list.addTab(tab1);
            }

        }

        fragAdapter = new FragAdapter(getSupportFragmentManager(),list,tab2);
        pager_list.setAdapter(fragAdapter);
    }

    @Override
    int initLayout() {
        return R.layout.tablist;
    }


}
