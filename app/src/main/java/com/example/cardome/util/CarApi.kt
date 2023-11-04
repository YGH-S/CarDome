package com.example.cardome.util

import com.example.cardome.bean.BrandlistBean
import com.example.cardome.bean.LogoBean
import com.example.cardome.bean.ModelListBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CarApi {
    companion object{

        val key = "833104579fdbf8e611371c20cb4264c6"
        val base_url = "http://apis.juhe.cn/cxdq/"
    }

    @GET("brand")
    open  fun getCarLogo(
            @Query("key")key:String,
            @Query("first_letter")first_letter:String): Call<LogoBean>?

    @GET("series")
    open  fun getBrandList(
        @Query("key")key:String,
        @Query("brandid")brandid:String): Call<BrandlistBean>?

    @GET("models")
    open  fun getModelList(
        @Query("key")key:String,
        @Query("series_id")series_id:String): Call<ModelListBean>?

}