package com.bawie.movie.view.activity;

import com.bawie.movie.R;
import com.bawie.movie.presenter.BasePresenter;
import com.bawie.movie.view.adapter.FragAdapter;
import com.bawie.movie.view.fragment.FragmentOne;
import com.bawie.movie.view.fragment.FragmentThree;
import com.bawie.movie.view.fragment.FragmentTwo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class TabActivity extends BaseActivity{

    private TabLayout tab;
    private ViewPager pager;
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
        tab = findViewById(R.id.tab);

        List<String> tab2=new ArrayList<>();
        tab2.add("电影");
        tab2.add("首页");
        tab2.add("我的");

        pager = findViewById(R.id.pager);
        tab.setupWithViewPager(pager);
        list = new ArrayList<>();
        list.add(new FragmentOne());
        list.add(new FragmentTwo());
        list.add(new FragmentThree());

        for (int i = 0; i <tab2.size() ; i++) {
            final String s = tab2.get(i);
            final TabLayout.Tab tab1 = this.tab.newTab();
            if (tab1!=null){
                tab1.setText(s);
                tab.addTab(tab1);
            }

        }
        tab.setupWithViewPager(pager);
        fragAdapter = new FragAdapter(getSupportFragmentManager(), list, tab2);
        pager.setAdapter(fragAdapter);

    }

    @Override
    int initLayout() {
        return R.layout.tablayout_main;
    }

}
