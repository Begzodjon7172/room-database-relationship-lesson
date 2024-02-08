package com.example.m1lesson57roomrelation.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.m1lesson57roomrelation.database.dao.RegionDao
import com.example.m1lesson57roomrelation.database.dao.StudentDao
import com.example.m1lesson57roomrelation.database.entity.Region
import com.example.m1lesson57roomrelation.database.entity.Student

@Database(entities = [Student::class, Region::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun regionDao(): RegionDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "my_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

    }
}