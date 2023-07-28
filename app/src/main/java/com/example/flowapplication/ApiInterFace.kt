package com.example.flowapplication

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiInterFace{

     @GET("v1/coins")
     suspend fun getCoins():List<DataModel>



 }