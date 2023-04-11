package com.example.retrofitlearning

import com.example.retrofitlearning.model.JokeResponse
import com.example.retrofitlearning.networking.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JokeRepository {
    suspend fun getRandomJoke(): Flow<JokeResponse?> {
        return flow {
            emit(
                Api.apiService.getRandomJoke().body()
            )
        }
    }
}