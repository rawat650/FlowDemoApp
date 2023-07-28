package com.example.flowapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

import kotlinx.coroutines.flow.flow

data class FlowViewModel(val id : Int,val isActive:Boolean,val title:String,val description:String)
data class FlowFormatted(val id : Int,val isActive:Boolean,val description:String,val title:String)


fun getList():Flow<FlowViewModel>{
    val list = listOf(
    FlowViewModel(1,true,"first","firstDesc"),
    FlowViewModel(2,false,"second","secondDEs"),
    FlowViewModel(3,true,"third","thirdDesc"))
    return list.asFlow()


}