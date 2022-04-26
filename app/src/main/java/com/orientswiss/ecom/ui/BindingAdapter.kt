package com.orientswiss.ecom.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingAdapter {
    // To set the image directly through data binding concept in list_item.xml part
    // we use Binding Adapter annotated with JvmStatic
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun setImageUrl(imageView: ImageView, url: String?) {
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }
}