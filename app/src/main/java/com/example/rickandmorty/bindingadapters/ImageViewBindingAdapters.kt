package com.example.rickandmorty.bindingadapters

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["android:src", "imageUrl"], requireAll = false)
fun ImageView.setImageResource(imageDrawable: Drawable? = null, imageUrl: String?) {
    if (imageUrl != null) {
        Glide.with(context)
            .load(imageUrl)
            .into(this)
    } else {
        setImageDrawable(imageDrawable)
    }
}