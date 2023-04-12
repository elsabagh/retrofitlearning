package com.example.retrofitlearning

import com.example.retrofitlearning.model.JokeResponse
import com.example.retrofitlearning.model.State
import com.example.retrofitlearning.networking.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class JokeRepository {
    suspend fun getRandomJoke(): Flow<State<JokeResponse?>> {
        return WrapWithFlow(Api.apiService::getRandomJoke)
    }

    fun <T> WrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                val result = function()
                if (result.isSuccessful) {
                    emit(State.Success(result.body()))
                } else {
                    emit(State.Error(result.message()))
                }
            } catch (e: Exception){
                emit(State.Error(e.message.toString()))
            }

        }
    }
}