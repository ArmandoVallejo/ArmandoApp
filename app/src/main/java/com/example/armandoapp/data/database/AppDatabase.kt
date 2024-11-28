package com.example.armandoapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.armandoapp.data.dao.ServiceDao
import com.example.armandoapp.data.model.ServiceEntity

@Database(entities = [ServiceEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun serviceDao(): ServiceDao

}