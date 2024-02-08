package com.example.m1lesson57roomrelation.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.m1lesson57roomrelation.database.entity.Student
import com.example.m1lesson57roomrelation.models.StudentWithRegion

@Dao
interface StudentDao {

    @Insert
    fun addStudent(student: Student)

    @Query("select * from student")
    fun getAllStudents(): List<Student>

    @Query("select * from student where id = :id")
    fun getStudentById(id: Int): Student

    @Transaction
    @Query("select * from student, region where student.region_id = region.id")
    fun getStudentsWithRegion(): List<StudentWithRegion>

}