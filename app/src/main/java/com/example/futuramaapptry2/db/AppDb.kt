package com.example.futuramaapptry2.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.futuramaapptry2.api.Character

@Database(entities = [Character::class], version = 1)
@TypeConverters(CharacterConverter::class)
abstract class AppDb : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}