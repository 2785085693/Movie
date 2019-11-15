package com.bawie.movie.view.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
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

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentOne extends BaseFragment<HomePresenter> implements AMapLocationListener,IHomeView.IRelease,IHomeView.IComint,IHomeView.IBase {
    private static final int MY_PERMISSIONS_REQUEST_CALL_LOCATION = 1;
    private AMapLocationClient mlocationClient;
    public AMapLocationClientOption mLocationOption = null;
    private XBanner banner_show;
    private ImageView imageView_show;
    private TextView textview_duo;
    private RecyclerView recyclerview_re;
    private ImageView imageView_show1;
    private TextView textview_duo1;
    private TextView crb3;
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
        crb3 = inflate.findViewById(R.id.crb3);
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

        //检查版本是否大于M
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_CALL_LOCATION);
            } else {
                //"权限已申请";
                showLocation();
            }
        }

        showLocation();
    }

    private void showLocation() {
        try {
            mlocationClient = new AMapLocationClient(getActivity());
            mLocationOption = new AMapLocationClientOption();
            mLocationOption.setNeedAddress(true);
            mlocationClient.setLocationListener((AMapLocationListener) this);
            //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            mLocationOption.setInterval(5000);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            //启动定位
            mlocationClient.startLocation();

        } catch (Exception e) {

        }
    }

    public void onLocationChanged(AMapLocation amapLocation) {
        try {
            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
                    /*//定位成功回调信息，设置相关消息
                    //获取当前定位结果来源，如网络定位结果，详见定位类型表
                    Log.i("定位类型", amapLocation.getLocationType() + "");
                    Log.i("获取纬度", amapLocation.getLatitude() + "");
                    Log.i("获取经度", amapLocation.getLongitude() + "");
                    Log.i("获取精度信息", amapLocation.getAccuracy() + "");

                    //如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                    Log.i("地址", amapLocation.getAddress());
                    Log.i("国家信息", amapLocation.getCountry());
                    Log.i("省信息", amapLocation.getProvince());
                    Log.i("城市信息", amapLocation.getCity());
                    Log.i("城区信息", amapLocation.getDistrict());
                    Log.i("街道信息", amapLocation.getStreet());
                    Log.i("街道门牌号信息", amapLocation.getStreetNum());
                    Log.i("城市编码", amapLocation.getCityCode());
                    Log.i("地区编码", amapLocation.getAdCode());
                    Log.i("获取当前定位点的AOI信息", amapLocation.getAoiName());
                    Log.i("获取当前室内定位的建筑物Id", amapLocation.getBuildingId());
                    Log.i("获取当前室内定位的楼层", amapLocation.getFloor());
                    Log.i("获取GPS的当前状态", amapLocation.getGpsAccuracyStatus() + "");*/


                    crb3.setText(amapLocation.getDistrict());
                    //dingwei.setText(amapLocation.getCity());

                    // 停止定位
                    mlocationClient.stopLocation();
                    mlocationClient.stopAssistantLocation();
                } else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + amapLocation.getErrorCode() + ", errInfo:"
                            + amapLocation.getErrorInfo());
                }
            }
        } catch (Exception e) {
        }
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
