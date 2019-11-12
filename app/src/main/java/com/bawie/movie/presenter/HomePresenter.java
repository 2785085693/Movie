package com.bawie.movie.presenter;

import com.bawie.movie.model.bean.ComingMovieBean;
import com.bawie.movie.model.bean.DetailsBean;
import com.bawie.movie.model.bean.FindBean;
import com.bawie.movie.model.bean.HotMovieBean;
import com.bawie.movie.model.bean.RecomBean;
import com.bawie.movie.model.bean.ReleaseMovieBean;
import com.bawie.movie.model.http.HttpUtils;
import com.bawie.movie.view.interfaces.IHomeView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class HomePresenter extends BasePresenter implements IHomeView.IHome,IHomeView.commint,IHomeView.release,IHomeView.IDetails,IHomeView.IFinds,IHomeView.Irecoms {

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


    public void detas(final IHomeView.IDeta iDeta) {
       HttpUtils.getHttpUtils().getDetails(new myCallBack() {
           @Override
           public void succes(String str) {
               final Gson gson = new Gson();
               final DetailsBean detailsBean = gson.fromJson(str, DetailsBean.class);
               iDeta.deta(detailsBean);
           }
       });
    }


    @Override
    public void finds(final IHomeView.IFind iFind) {
        HttpUtils.getHttpUtils().getFind(new myCallBack() {
            @Override
            public void succes(String str) {
                Gson gson = new Gson();
                FindBean findBean = gson.fromJson(str, FindBean.class);
                iFind.find(findBean);
            }
        });
    }

    @Override
    public void recoms(final IHomeView.IRecom irecom) {
        HttpUtils.getHttpUtils().getRecom(new myCallBack() {
            @Override
            public void succes(String str) {
                final Gson gson = new Gson();
                final RecomBean recomBean = gson.fromJson(str, RecomBean.class);
                irecom.recom(recomBean);
            }
        });
    }

    public interface myCallBack{
        void succes(String str);
    }



}
