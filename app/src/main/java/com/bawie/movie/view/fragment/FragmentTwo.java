package com.bawie.movie.view.fragment;

import android.widget.ImageView;

import com.bawie.movie.R;
import com.bawie.movie.presenter.BasePresenter;
import com.bawie.movie.view.adapter.FragAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class FragmentTwo extends BaseFragment {

    private TabLayout tab;
    private ViewPager pager;
    private List<Fragment> list;
    private FragAdapter fragAdapter;

    @Override
    void initData() {

    }

    @Override
    BasePresenter setFragment() {
        return new BasePresenter();
    }

    @Override
    void initView() {
        tab = inflate.findViewById(R.id.tab);

        pager = inflate.findViewById(R.id.pager);
        List<String> tab2=new ArrayList<>();
        tab2.add("推荐影院");
        tab2.add("附近影院");
        tab2.add("海淀区");

        tab.setupWithViewPager(pager);
        list = new ArrayList<>();
        list.add(new FragmentRecom());
        list.add(new FragmentRecoms());
        list.add(new FragmentRecomd());

        for (int i = 0; i <tab2.size() ; i++) {
            final String s = tab2.get(i);
            final TabLayout.Tab tab1 = this.tab.newTab();
            if (tab1!=null){
                tab1.setText(s);
                tab.addTab(tab1);
            }

        }

        fragAdapter = new FragAdapter(getChildFragmentManager(),list,tab2);
        pager.setAdapter(fragAdapter);

    }

    @Override
    int initLayout() {
        return R.layout.fragtwo;
    }
}
