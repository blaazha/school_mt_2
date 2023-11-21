package com.example.futuramaapptry2.db

import androidx.room.TypeConverter
import com.example.futuramaapptry2.api.Images
import com.example.futuramaapptry2.api.Name
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CharacterConverter {
    @TypeConverter
    fun fromName(name: Name): String = Gson().toJson(name)

    @TypeConverter
    fun toName(nameString: String): Name = Gson().fromJson(nameString, Name::class.java)

    @TypeConverter
    fun fromImages(images: Images): String = Gson().toJson(images)

    @TypeConverter
    fun toImages(imagesString: String): Images = Gson().fromJson(imagesString, Images::class.java)

    @TypeConverter
    fun fromStringList(list: List<String>): String = Gson().toJson(list)

    @TypeConverter
    fun toStringList(listString: String): List<String> = Gson().fromJson(listString, object : TypeToken<List<String>>() {}.type)
}