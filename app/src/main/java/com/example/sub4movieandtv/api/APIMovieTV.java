package com.example.sub4movieandtv.api;

import com.example.sub4movieandtv.model.MovieRespon;
import com.example.sub4movieandtv.model.TVRespon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIMovieTV {

    @GET("discover/movie")
    Call<MovieRespon> getMovieList(
            @Query("api_key") String apikey,
            @Query("language") String language);

    @GET("discover/tv")
    Call<TVRespon> getTVList(
            @Query("api_key") String apikey,
            @Query("language") String language);

}