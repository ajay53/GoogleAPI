package com.example.googleapi.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.googleapi.R;
import com.example.googleapi.adapter.GlideApp;
import com.example.googleapi.databinding.BookCardBinding;
import com.example.googleapi.model.books.BooksVolume;
import com.example.googleapi.model.books.Item;
import com.example.googleapi.viewmodel.BooksViewModel;

import java.util.List;

public class BooksFragment extends Fragment {
    private static final String TAG = "BooksFragment";

    private Context context;
    private BooksViewModel viewModel;
    private LinearLayout llBooks;
    private View bookCard;
    private Item item;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_books, container, false);

        initializeViews(root);

        return root;
    }

    private void init() {
        context = getContext();

        viewModel = new ViewModelProvider(this).get(BooksViewModel.class);
        viewModel.getBooksApi();
    }

    private void initializeViews(View root) {
        llBooks = root.findViewById(R.id.llBooks);
        ProgressBar progressBar = root.findViewById(R.id.progressBar);

        viewModel.getBooksVolume().observe(getViewLifecycleOwner(), booksVolume -> {
            llBooks.removeAllViews();
            displayBooks(booksVolume.getItems());
            progressBar.setVisibility(View.INVISIBLE);
        });
    }

    private void displayBooks(List<Item> items) {
        Log.d(TAG, "displayBooks: ");

        LinearLayout ll;

        BookCardBinding binding;
        LinearLayout.LayoutParams rootLayoutParams;
        LinearLayout.LayoutParams llLayoutParams;

        for (int bookCounter = 0; bookCounter < items.size(); bookCounter += 2) {

            //creating linearLayout for each row(2 products)
            ll = new LinearLayout(context);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            llLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 2);
            llLayoutParams.setMargins(0, 0, 0, 20);
            ll.setLayoutParams(llLayoutParams);

            //adding 1st product in a row in ll
            item = items.get(bookCounter);
            binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.book_card, null, false);
            binding.setItem(item);
//            binding.setCustomClick(this);
            rootLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            rootLayoutParams.setMargins(0, 0, 10, 0);
            bookCard = binding.getRoot();

            bookCard.setLayoutParams(rootLayoutParams);
            ll.addView(bookCard);

            //adding 2nd product in a row in ll
            if (bookCounter + 1 < items.size()) {
                item = items.get(bookCounter + 1);
                binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.book_card, null, false);
                binding.setItem(item);
//                binding.setCustomClick(this);
                rootLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1);
                rootLayoutParams.setMargins(10, 0, 0, 0);
                bookCard = binding.getRoot();
                bookCard.setLayoutParams(rootLayoutParams);
                ll.addView(bookCard);
            }

            //adding ll(1 row) in vertical linearLayout
            llBooks.addView(ll);
        }
    }
}