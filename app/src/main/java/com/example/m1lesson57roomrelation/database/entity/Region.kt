package com.example.m1lesson57roomrelation.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Region(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String
)
