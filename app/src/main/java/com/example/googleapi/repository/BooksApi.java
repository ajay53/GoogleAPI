package com.example.googleapi.repository;


import com.example.googleapi.model.books.BooksVolume;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksApi {

    @GET("volumes")
    Call<BooksVolume> getBooks(@Query("q") String value);
}
