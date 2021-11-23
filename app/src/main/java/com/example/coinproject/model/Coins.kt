package com.example.coinproject.model

import com.google.gson.annotations.SerializedName

data class Coins(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    @SerializedName("current_price")
    val currentprice: String
)
