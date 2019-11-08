package com.bawie.movie.model.http;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface API {




    @GET("movie/v2/findComingSoonMovieList?page=1&count=10")
    Observable<ResponseBody> coming();

    @GET("movie/v2/findReleaseMovieList?page=1&count=10")
    Observable<ResponseBody> release();

    @GET("movie/v2/findHotMovieList?page=1&count=10")
    Observable<ResponseBody> hot();
}
