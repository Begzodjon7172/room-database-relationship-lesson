package com.example.m1lesson57roomrelation.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.m1lesson57roomrelation.database.entity.Region

@Dao
interface RegionDao {

    @Insert
    fun addRegion(region: Region)

    @Query("select * from region")
    fun getAllRegions(): List<Region>

    @Query("select * from region where id = :id")
    fun getRegionById(id: Int): Region

}