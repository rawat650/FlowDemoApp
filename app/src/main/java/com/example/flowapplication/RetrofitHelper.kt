package com.example.flowapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getInstance():ApiInterFace{
       return  Retrofit.Builder().baseUrl("https://api.coinpaprika.com/").addConverterFactory(GsonConverterFactory.create()).build().create(ApiInterFace::class.java)
    }
}