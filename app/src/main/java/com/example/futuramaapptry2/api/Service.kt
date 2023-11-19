package com.example.futuramaapptry2.api


import retrofit2.http.GET

interface ApiService {
    @GET("futurama/characters")
    suspend fun getCharacters(): List<Character>
}