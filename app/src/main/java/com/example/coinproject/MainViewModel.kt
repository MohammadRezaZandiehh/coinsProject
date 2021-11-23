package com.example.coinproject

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinproject.Apiservice.ApiService
import com.example.coinproject.PixabyModel.PixabyPost
import com.example.coinproject.model.CoinsItem
import kotlinx.coroutines.launch
import retrofit2.Call

class MainViewModel@ViewModelInject constructor(
    private val apiService: ApiService
) :ViewModel(){

 val coinLiveData = MutableLiveData<Call<List<CoinsItem>>>()
// val coinLiveData = MutableLiveData<Call<WeatherResponse>>()

    init {
        getCoins()
    }

    fun getCoins(){
        viewModelScope.launch {
            val coins = apiService.getCoins()
            coinLiveData.value = coins
        }
    }
}