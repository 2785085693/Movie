package com.bawie.movie.presenter;

import com.bawie.movie.model.bean.ComingMovieBean;
import com.bawie.movie.model.bean.HotMovieBean;
import com.bawie.movie.model.bean.ReleaseMovieBean;
import com.bawie.movie.model.http.HttpUtils;
import com.bawie.movie.view.interfaces.IHomeView;
import com.google.gson.Gson;

public class HomePresenter extends BasePresenter implements IHomeView.IHome,IHomeView.commint,IHomeView.release {

    @Override
    public void load(final IHomeView.IBase iBase) {
        HttpUtils.getHttpUtils().getData(new myCallBack() {
            @Override
            public void succes(String str) {
                Gson gson = new Gson();
                HotMovieBean hotMovieBean = gson.fromJson(str,HotMovieBean.class);
                iBase.ok(hotMovieBean);
            }
        });
    }

    @Override
    public void shang(final IHomeView.IComint iComint) {
        HttpUtils.getHttpUtils().getComing(new myCallBack() {
            @Override
            public void succes(String str) {
                Gson gson = new Gson();
                ComingMovieBean comingMovieBean = gson.fromJson(str,ComingMovieBean.class);
                iComint.comint(comingMovieBean);
            }
        });
    }

    @Override
    public void zheng(final IHomeView.IRelease iRelease) {
        HttpUtils.getHttpUtils().getRelease(new myCallBack() {
            @Override
            public void succes(String str) {
                Gson gson = new Gson();
                ReleaseMovieBean releaseMovieBean = gson.fromJson(str,ReleaseMovieBean.class);
                iRelease.releas(releaseMovieBean);
            }
        });
    }

    public interface myCallBack{
        void succes(String str);
    }
}
