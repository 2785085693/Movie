package com.bawie.movie.model.http;

import com.bawie.movie.presenter.HomePresenter;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {

    private static HttpUtils httpUtils = new HttpUtils();
    private Retrofit builder;

    public static HttpUtils getHttpUtils() {
        return httpUtils;
    }

    private HttpUtils(){

    }
    //热门电影
    public void getData(final HomePresenter.myCallBack myCallBack){
        builder = new Retrofit.Builder()
            .baseUrl("http://172.17.8.100/movieApi/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
        API api = builder.create(API.class);
        Observable<ResponseBody> coming = api.coming();
        coming.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            final String string = responseBody.string();
                            myCallBack.succes(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //正在上映
    public void getRelease(final HomePresenter.myCallBack myCallBack){
        builder = new Retrofit.Builder()
                .baseUrl("http://172.17.8.100/movieApi/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        API api = builder.create(API.class);
        Observable<ResponseBody> release = api.release();
        release.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            final String string = responseBody.string();
                            myCallBack.succes(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //即将上映
    public void getComing(final HomePresenter.myCallBack myCallBack){
        builder = new Retrofit.Builder()
                .baseUrl("http://172.17.8.100/movieApi/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        API api = builder.create(API.class);
        Observable<ResponseBody> hot = api.hot();
        hot.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            final String string = responseBody.string();
                            myCallBack.succes(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
