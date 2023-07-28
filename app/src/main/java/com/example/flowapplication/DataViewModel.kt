package com.example.flowapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

class DataViewModel(val repository: DataRepository): ViewModel() {

    val _dataStateFlow = MutableStateFlow<UiState<List<DataModel>>>(UiState(null))
    val dataflow : StateFlow<UiState<List<DataModel>>> = _dataStateFlow

    fun getData(){
        viewModelScope.launch(Dispatchers.IO) {
            _dataStateFlow.emit(UiState(isLoading = true))
            val response= repository.getCoin()
            response.collect{
               when(it){

                   is Resource.Success -> _dataStateFlow.emit(UiState((it.data as? List<DataModel>)?.filter {
                       it.isActive!!
                   }))

                   is Resource.Error -> _dataStateFlow.emit(UiState(errr = it.message))
               }
            }
           /* response.collect{

                it.filter {
                }
            }*/
        }
    }
}