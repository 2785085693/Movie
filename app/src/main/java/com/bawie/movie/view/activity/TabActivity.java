package com.bawie.movie.view.activity;

import android.widget.RadioGroup;

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

public class TabActivity extends BaseActivity{


    private ViewPager pager;
    private List<Fragment> list = new ArrayList<>();
    private RadioGroup group_tab;


    @Override
    void initData() {

    }

    @Override
    BasePresenter setPresenter() {
        return new BasePresenter();
    }

    @Override
    void initView() {

        group_tab = findViewById(R.id.group_tab);

        pager = findViewById(R.id.pager);

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


        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                group_tab.check(group_tab.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


        });
        group_tab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.but_tably:

                        pager.setCurrentItem(0);
                        break;

                    case R.id.but_tably1:
                        pager.setCurrentItem(1);
                        break;

                    case R.id.but_tably2:
                        pager.setCurrentItem(2);
                        break;
                }
            }
        });



    }

    @Override
    int initLayout() {
        return R.layout.tablayout_main;
    }

}
