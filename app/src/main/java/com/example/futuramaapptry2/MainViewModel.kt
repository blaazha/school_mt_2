package com.example.futuramaapptry2

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.futuramaapptry2.api.ApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.futuramaapptry2.api.Character
import com.example.futuramaapptry2.db.AppDb
import kotlin.math.log

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var fetched = false;
    private val db = Room.databaseBuilder(
        application,
        AppDb::class.java,
        "futurama-db1"
    ).build()

    private val characterDao = db.characterDao()

    private val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    val characters: LiveData<List<Character>> = characterDao.getAllCharacters()

    init {
        if (!fetched)
            fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response = apiService.getCharacters()
                characterDao.insertAll(response)
                fetched = true;
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching characters", e)
            }
        }
    }
}