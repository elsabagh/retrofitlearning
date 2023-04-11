package com.example.retrofitlearning

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitlearning.model.JokeResponse
import com.example.retrofitlearning.networking.Api
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val repository = JokeRepository()

    val joke = MutableLiveData<JokeResponse>()

    init {
        getRandomJoke()
    }

    private fun getRandomJoke() {
        viewModelScope.launch {
            repository.getRandomJoke().collect {
                joke.postValue(it)
            }
        }

    }

    // retrofit with Rxjava3
//    private fun getRandomJoke() {
//        Api.apiService.getRandomJoke()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                {
//                    joke.postValue(it)
//                },
//                {
//
//                }
//            )
//    }
}