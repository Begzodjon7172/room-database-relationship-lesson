package com.example.m1lesson57roomrelation.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Region::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("region_id")
    )]
)
data class Student(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String,
    var age: Int,
    @ColumnInfo(name = "region_id")
    var regionId: Long
)
