package com.example.googleapi.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.googleapi.model.books.BooksVolume;
import com.example.googleapi.model.news.News;
import com.example.googleapi.repository.BooksWebServiceClient;
import com.example.googleapi.repository.NewsWebServiceClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    private static final String TAG = "NewsViewModel";

    private MutableLiveData<News> mNews;

    public NewsViewModel() {
        mNews = new MutableLiveData<>();
    }

    public LiveData<News> getHeadLines() {
        return mNews;
    }

    public void getHeadlinesApi() {
        Log.d(TAG, "getHeadlinesApi: ");

        Call<News> booksCall = NewsWebServiceClient.newsApi.getHeadlines("in", "ca68d8f56f634a5e998d8b51bd842575");

        booksCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(@NonNull Call<News> call, @NonNull Response<News> response) {

                if (!response.isSuccessful()) {
                    Log.e(TAG, "onResponse: Code" + response.code());
                    return;
                }
                mNews.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<News> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}