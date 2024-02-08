package com.example.m1lesson57roomrelation.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.m1lesson57roomrelation.database.entity.Region
import com.example.m1lesson57roomrelation.database.entity.Student

data class StudentWithRegion(
    @Embedded val region: Region,

    @Relation(
        parentColumn = "id",
        entityColumn = "region_id"
    )
    val student: Student
)