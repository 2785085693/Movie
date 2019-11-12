package com.bawie.movie.model.http;

import com.bawie.movie.model.bean.DetailsBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;

public interface API {




    @GET("movie/v2/findComingSoonMovieList?page=1&count=10")
    Observable<ResponseBody> coming();

    @GET("movie/v2/findReleaseMovieList?page=1&count=10")
    Observable<ResponseBody> release();

    @GET("movie/v2/findHotMovieList?page=1&count=10")
    Observable<ResponseBody> hot();

    @GET("movie/v2/findMoviesDetail?movieId=22")
    Observable<ResponseBody> Detai();


    @GET("movie/v2/findAllMovieComment?userId=13673&sessionId=157345538372113673&movieId=24&page=1&count=10")
    Observable<ResponseBody> find();

    //推荐影院
    @GET("cinema/v1/findRecommendCinemas?sessionId=157103542099413673&userId=13673&page=1&count=10")
    Observable<ResponseBody> recom();


}
