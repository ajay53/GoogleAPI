package com.example.googleapi.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.request.RequestOptions;
import com.example.googleapi.R;

public class GlideBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void setImageResource(ImageView view, String url) {

        Context context = view.getContext();

        //replacing "http" with "https"
        if (url.charAt(4) != 's') {
            url = "https" + url.substring(4);
        }

        GlideApp.with(context)
                .load(url)
                .placeholder(R.drawable.ic_book_24)
                .into(view);
    }
}


