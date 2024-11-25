package com.example.armandoapp.data.database

import androidx.room.Database

@Database(entities = [ServiceEntity::class], version = 1)
abstract class AppDatabase {
    abstract fun serviceDao(): ServiceDao

}