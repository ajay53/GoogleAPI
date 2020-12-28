package com.example.googleapi.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.googleapi.R;
import com.example.googleapi.adapter.NewsRecyclerViewAdapter;
import com.example.googleapi.model.news.Article;
import com.example.googleapi.viewmodel.BooksViewModel;
import com.example.googleapi.viewmodel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment implements NewsRecyclerViewAdapter.OnItemCLickListener {
    private static final String TAG = "NewsFragment";

    private NewsViewModel viewModel;
    private Context context;
    private RecyclerView rvNews;
    private NewsRecyclerViewAdapter recyclerViewAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news, container, false);

        initializeViews(root);
        setRecyclerView(new ArrayList<>());
        return root;
    }

    private void init() {
        context = getContext();

        viewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        viewModel.getHeadlinesApi();
    }

    private void initializeViews(View root) {
        ProgressBar progressBar = root.findViewById(R.id.progressBar);
        rvNews = root.findViewById(R.id.rvNews);

        viewModel.getHeadLines().observe(getViewLifecycleOwner(), headlines -> {
            recyclerViewAdapter.notifyDataSetChanged();
            setRecyclerView(headlines.getArticles());
            progressBar.setVisibility(View.INVISIBLE);
        });
    }

    private void setRecyclerView(List<Article> articles) {
        Log.d(TAG, "setRecyclerView: ");

        recyclerViewAdapter = new NewsRecyclerViewAdapter(context, articles, this);
        rvNews.setAdapter(recyclerViewAdapter);
        rvNews.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public void onNewsClick(int position) {
        Log.d(TAG, "onNewsClick: ");
    }
}