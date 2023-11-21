package com.example.futuramaapptry2.api

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.Nullable
import java.io.Serializable

@Entity
data class Character (
    val name: Name,
    val images: Images,
    val gender: String,
    val species: String,
    val homePlanet: String?,
    val occupation: String,
    val sayings: List<String>,
    @PrimaryKey val id: Int,
    val age: String
) : Serializable

data class Name(
    val first: String,
    val middle: String,
    val last: String
) : Serializable

data class Images(
    val headShot: String,
    val main: String
) : Serializable