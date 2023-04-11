package com.example.retrofitlearning.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Api{
    private val BASE_URL = "https://v2.jokeapi.dev/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
//        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // use with rxjava3
        .build()
    val apiService = retrofit.create(JokeApiService::class.java)
}