package com.example.coinproject.Apiservice

import com.example.coinproject.PixabyModel.PixabyPost
import com.example.coinproject.model.CoinsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false")
    open fun getCoins(): Call<List<CoinsItem>>
//    @GET("?key=20103943-432378ad3ccb78b05090ddc4b&q=birds&image_type=photo")
//    @GET("find?lat=55.5&lon=37.5&cnt=10&appid=05e3e40f3e0c3d3220344dcbc089b43c")
//    open fun getCoins(): Call<WeatherResponse>
}