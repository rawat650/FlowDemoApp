package com.example.flowapplication

import kotlin.jvm.internal.Ref.BooleanRef

data class UiState<T> (val data :T? = null,val errr : String = "",val isLoading:Boolean = false)