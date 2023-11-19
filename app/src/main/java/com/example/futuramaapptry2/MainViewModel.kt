package com.example.futuramaapptry2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.futuramaapptry2.api.ApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.futuramaapptry2.api.Character

class MainViewModel: ViewModel() {
    private val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    private val _characters = MutableLiveData<List<Character>>()

    val characters: LiveData<List<Character>> = _characters
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response = apiService.getCharacters()
                _characters.postValue(response)
            } catch (e: Exception) {
                // Handle exceptions
            }
        }
    }
}