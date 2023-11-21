package com.example.futuramaapptry2.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.futuramaapptry2.api.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character")
    fun getAllCharacters(): LiveData<List<Character>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<Character>)
}