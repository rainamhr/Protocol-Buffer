package com.mobile.protocolbuffer.protoApp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProtoViewModel(application: Application) : AndroidViewModel(application) {

    val repository = ProtoRepository(application)

    val fullName = repository.readProto.asLiveData()
    val mobile = repository.readProto.asLiveData()
    val address = repository.readProto.asLiveData()

    fun updateValue(fullName: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateFullName(fullName)
    }

    fun updateMobile(mobile: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateMobile(mobile)
    }

    fun updateAddress(address: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateAddress(address)
    }
}