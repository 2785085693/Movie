package com.bawie.movie.view.adapter;

import android.content.Context;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragAdapter  extends FragmentPagerAdapter {

    private Context context;
    private List<Fragment> list ;
    private List<String> slist ;

    public FragAdapter(@NonNull FragmentManager fm, List<Fragment> list, List<String> slist) {
        super(fm);
        this.context = context;
        this.list = list;
        this.slist = slist;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return slist.get(position%list.size());
    }
}
