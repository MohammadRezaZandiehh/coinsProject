package com.example.coinproject.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinproject.Apiservice.ApiService
import com.example.coinproject.model.Coins
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val apiService: ApiService
) : ViewModel() {
    val coinsLiveData = MutableLiveData<List<Coins>>()
    private val errorLiveData = MutableLiveData<String>()

    init {
        viewModelScope.launch {
            val students = apiService.getCoins()
            coinsLiveData.value = students
        }
    }
}