package com.example.cardome.adapter

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.cardome.R
import com.squareup.picasso.Picasso

object ImageViewBindingAdapter {

    @BindingAdapter("itemImage")
    @JvmStatic
    fun setImage(iv : ImageView, url : String){
        if (TextUtils.isEmpty(url)){
            iv.setImageResource(R.mipmap.car)
        }else{
            Picasso.get()
                .load(url)
                .placeholder(R.mipmap.car)
                .error(R.mipmap.car)
                .into(iv)
        }
    }
}