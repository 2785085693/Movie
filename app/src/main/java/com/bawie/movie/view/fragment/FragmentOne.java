package com.bawie.movie.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.ComingMovieBean;
import com.bawie.movie.model.bean.HotMovieBean;
import com.bawie.movie.model.bean.ReleaseMovieBean;
import com.bawie.movie.presenter.HomePresenter;
import com.bawie.movie.view.activity.TablistActivity;
import com.bawie.movie.view.adapter.ComingAdapter;
import com.bawie.movie.view.adapter.HotAdapter;
import com.bawie.movie.view.adapter.IHotAdapter;
import com.bawie.movie.view.adapter.ReleaseAdapter;
import com.bawie.movie.view.interfaces.IHomeView;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentOne extends BaseFragment<HomePresenter> implements IHomeView.IRelease,IHomeView.IComint,IHomeView.IBase {
    private XBanner banner_show;
    private ImageView imageView_show;
    private TextView textview_duo;
    private RecyclerView recyclerview_re;
    private ImageView imageView_show1;
    private TextView textview_duo1;
    private RecyclerView recyclerview_jj;
    private ImageView imageView_show2;
    private TextView textview_duo2;
    private RecyclerView recyclerview_men;
    private RecyclerView recyclerview_rm;

    @Override
    void initData() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerview_re.setLayoutManager(layoutManager);
        f.zheng(this);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(RecyclerView.VERTICAL);
        recyclerview_jj.setLayoutManager(layoutManager1);
        f.shang(this);

      /*  LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        layoutManager2.setOrientation(RecyclerView.HORIZONTAL);
        recyclerview_rm.setLayoutManager(layoutManager2);
        f.load(this);*/

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getContext());
        layoutManager3.setOrientation(RecyclerView.HORIZONTAL);
        recyclerview_men.setLayoutManager(layoutManager3);
        f.load(this);

    }

    @Override
    HomePresenter setFragment() {
        return new HomePresenter();
    }

    @Override
    void initView() {
        recyclerview_re = inflate.findViewById(R.id.recyclerview_re);
        recyclerview_jj = inflate.findViewById(R.id.recyclerview_jj);
        recyclerview_men = inflate.findViewById(R.id.recyclerview_men);
     //   recyclerview_rm = inflate.findViewById(R.id.recyclerview_rm);

        banner_show =inflate.findViewById(R.id.banner_show);

        final List<String> imgesUrl = new ArrayList<>();
        imgesUrl.add("http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1_h.jpg");
        imgesUrl.add( "http://172.17.8.100/images/movie/stills/mtyj/mtyj1_h.jpg");
        imgesUrl.add("http://172.17.8.100/images/movie/stills/ws/ws1_h.jpg");
        imgesUrl.add("http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg1_h.jpg");
        imgesUrl.add("http://172.17.8.100/images/movie/stills/dwsj/dwsj1_h.jpg");
        // 为XBanner绑定数据
        banner_show .setData(imgesUrl,null);
        // XBanner适配数据
        banner_show.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
               Glide.with(getActivity()).load(imgesUrl.get(position)).into((ImageView) view);;
            }
        });
        banner_show.setPageTransformer(Transformer.Default);  //单页旋转
        banner_show.setPageTransformer(Transformer.Cube);

        banner_show.setPageChangeDuration(1000);

        textview_duo = inflate.findViewById(R.id.textview_duo);

        textview_duo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TablistActivity.class);
                startActivity(intent);
            }
        });


        textview_duo1 = inflate.findViewById(R.id.textview_duo1);

        textview_duo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TablistActivity.class);
                startActivity(intent);
            }
        });
        textview_duo2 = inflate.findViewById(R.id.textview_duo2);

        textview_duo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TablistActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    int initLayout() {
        return R.layout.show_home;
    }

    //正在热映
    @Override
    public void releas(ReleaseMovieBean releaseMovieBean) {

        ReleaseAdapter releaseAdapter = new ReleaseAdapter(releaseMovieBean.getResult(), getActivity());
        recyclerview_re.setAdapter(releaseAdapter);
    }

    @Override
    public void comint(ComingMovieBean comingMovieBean) {
        ComingAdapter comingAdapter = new ComingAdapter(getActivity(), comingMovieBean.getResult());
        recyclerview_jj.setAdapter(comingAdapter);
    }

    @Override
    public void ok(HotMovieBean hotMovieBean) {
       // HotAdapter hotAdapter = new HotAdapter(getActivity(), hotMovieBean.getResult());
       // recyclerview_rm.setAdapter(hotAdapter);

        IHotAdapter iHotAdapter = new IHotAdapter(getContext(), hotMovieBean.getResult());
        recyclerview_men.setAdapter(iHotAdapter);
    }
}
