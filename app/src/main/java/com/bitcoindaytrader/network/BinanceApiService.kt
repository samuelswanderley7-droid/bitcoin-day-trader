// BinanceApiService.kt

package com.bitcoindaytrader.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BinanceApiService {
    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.binance.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Add your API methods here
}