package com.example.flowapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DataFactory(val repository : DataRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DataViewModel(repository) as T
    }
}