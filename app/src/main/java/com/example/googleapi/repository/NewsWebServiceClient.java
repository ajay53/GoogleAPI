package com.example.googleapi.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsWebServiceClient {

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/s/google-news-api")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static NewsApi newsApi = retrofit.create(NewsApi.class);
}
