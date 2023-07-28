package com.example.flowapplication

import kotlinx.coroutines.flow.flow

class DataRepository {
suspend fun getCoin() = flow {
       //val response =
       try {

              emit(
                     Resource.Success(
                            RetrofitHelper.getInstance().getCoins()
                     )
              )
       }
       catch (e:Exception){
              emit(Resource.Error(e.localizedMessage))

       }
}
}