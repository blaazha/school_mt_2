package com.example.futuramaapptry2.api

data class Character(
    val name: Name,
    val images: Images,
    val gender: String,
    val species: String,
    val homePlanet: String,
    val occupation: String,
    val sayings: List<String>,
    val id: Int,
    val age: String
)

data class Name(
    val first: String,
    val middle: String,
    val last: String
)

data class Images(
    val headShot: String,
    val main: String
)