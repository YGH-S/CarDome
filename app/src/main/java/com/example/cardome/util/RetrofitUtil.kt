package com.example.cardome.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtil {
    private var retrofit:Retrofit? = null

    fun getRetrofit(base_url : String) : Retrofit{
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    fun <T>getApi(base_url: String,cls:Class<T>?) : T{
        val retrofit = getRetrofit(base_url)
        return retrofit.create(cls)
    }
}