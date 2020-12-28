package com.example.googleapi.repository;

import com.example.googleapi.model.news.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("top-headlines")
    Call<News> getHeadlines(@Query("country") String country, @Query("apiKey") String API_KEY);
}
