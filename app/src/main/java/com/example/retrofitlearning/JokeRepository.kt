package com.example.retrofitlearning

import com.example.retrofitlearning.model.JokeResponse
import com.example.retrofitlearning.model.State
import com.example.retrofitlearning.networking.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JokeRepository {
    suspend fun getRandomJoke(): Flow<State<JokeResponse?>> {
        return flow {
            emit(State.Loading)
            val result = Api.apiService.getRandomJoke()
            if (result.isSuccessful){
                emit(State.Success(result.body()))
            }else{
                emit(State.Error(result.message()))
            }
        }
    }
}