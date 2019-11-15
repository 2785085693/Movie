package com.bawie.movie.view.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.DetailsBean;
import com.bawie.movie.presenter.HomePresenter;
import com.bawie.movie.view.interfaces.IHomeView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class FragmentfFive extends BaseFragment<HomePresenter> implements IHomeView.IDeta {

    private JZVideoPlayerStandard videoplayer;

    @Override
    void initData() {


        f.detas(this);
    }

    @Override
    HomePresenter setFragment() {
        return new HomePresenter();
    }

    @Override
    void initView() {
        videoplayer = inflate.findViewById(R.id.videoplayer);

    }

    @Override
    int initLayout() {
        return R.layout.fragfive;
    }

    @Override
    public void deta(DetailsBean detailsBean) {



        for (int i = 0; i < detailsBean.getResult().getShortFilmList().size(); i++) {
            videoplayer.setUp(detailsBean.getResult().getShortFilmList().get(i).
                    getVideoUrl(), JZVideoPlayer.SCREEN_WINDOW_NORMAL,"视频");

        }



    }

    @Override
    public void onPause() {
        super.onPause();
        JZVideoPlayerStandard.releaseAllVideos();
    }

}
