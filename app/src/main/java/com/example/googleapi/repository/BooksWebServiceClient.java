package com.example.googleapi.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BooksWebServiceClient {

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static BooksApi booksApi = retrofit.create(BooksApi.class);
}
