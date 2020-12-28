package com.example.googleapi.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.googleapi.model.books.BooksVolume;
import com.example.googleapi.repository.BooksWebServiceClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksViewModel extends ViewModel {
    private static final String TAG = "HomeViewModel";

    private final MutableLiveData<BooksVolume> mBooksVolume;

    public BooksViewModel() {
        mBooksVolume = new MutableLiveData<>();
    }

    public LiveData<BooksVolume> getBooksVolume() {
        return mBooksVolume;
    }

    public void getBooksApi() {
        Log.d(TAG, "getBooksApi: ");

        Call<BooksVolume> booksCall = BooksWebServiceClient.booksApi.getBooks("search+terms");

        booksCall.enqueue(new Callback<BooksVolume>() {
            @Override
            public void onResponse(@NonNull Call<BooksVolume> call, @NonNull Response<BooksVolume> response) {

                if (!response.isSuccessful()) {
                    Log.e(TAG, "onResponse: Code" + response.code());
                    return;
                }
                mBooksVolume.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<BooksVolume> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}