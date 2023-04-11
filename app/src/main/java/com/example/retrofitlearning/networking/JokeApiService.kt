package com.example.retrofitlearning.networking

import com.example.retrofitlearning.model.JokeResponse
import retrofit2.Response
import retrofit2.http.GET

interface JokeApiService {
    @GET("joke/Any")
    suspend fun getRandomJoke(): Response<JokeResponse> //use with coroutines
//    fun getRandomJoke() : Single<JokeResponse> //use with rxjava3
}
