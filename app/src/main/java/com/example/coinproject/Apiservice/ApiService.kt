package com.example.coinproject.Apiservice


import com.example.coinproject.model.Coins
import retrofit2.http.GET

interface ApiService {

    @GET("markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false")
    suspend fun getCoins() : List<Coins>
}