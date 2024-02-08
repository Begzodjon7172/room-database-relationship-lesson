package com.example.m1lesson57roomrelation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m1lesson57roomrelation.adapters.RegionAdapter
import com.example.m1lesson57roomrelation.adapters.StudentAdapter
import com.example.m1lesson57roomrelation.database.AppDatabase
import com.example.m1lesson57roomrelation.database.entity.Region
import com.example.m1lesson57roomrelation.database.entity.Student
import com.example.m1lesson57roomrelation.databinding.ActivityMainBinding
import com.example.m1lesson57roomrelation.models.StudentWithRegion

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var appDatabase: AppDatabase
    private lateinit var regionList: ArrayList<Region>
    private lateinit var studentList: ArrayList<StudentWithRegion>
    private lateinit var regionAdapter: RegionAdapter
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        appDatabase = AppDatabase.getInstance(this)

//        appDatabase.regionDao().addRegion(Region(name = "Andijon"))
//        appDatabase.regionDao().addRegion(Region(name = "Namangan"))
//        appDatabase.regionDao().addRegion(Region(name = "Toshkent"))
//        appDatabase.regionDao().addRegion(Region(name = "Farg'ona"))
//        appDatabase.regionDao().addRegion(Region(name = "Buxoro"))
//        appDatabase.regionDao().addRegion(Region(name = "Navoiy"))
//        appDatabase.regionDao().addRegion(Region(name = "Qashqadaryo"))
//        appDatabase.regionDao().addRegion(Region(name = "Surxondaryo"))
//        appDatabase.regionDao().addRegion(Region(name = "Xorazm"))

        regionList = ArrayList(appDatabase.regionDao().getAllRegions())
        regionAdapter = RegionAdapter(regionList)

        studentList = ArrayList(appDatabase.studentDao().getStudentsWithRegion())
        studentAdapter = StudentAdapter(studentList)


        binding.apply {

            spinner.adapter = regionAdapter
            rv.adapter = studentAdapter

            saveBtn.setOnClickListener {

                val name = edtName.text.toString()
                val age = edtAge.text.toString().toInt()
                val region = regionList[spinner.selectedItemPosition]
                val regionId = regionList[spinner.selectedItemPosition].id

                val student = Student(name = name, age = age, regionId = regionId)
                appDatabase.studentDao().addStudent(student)
                studentList.add(StudentWithRegion(region, student))
                studentAdapter.notifyItemInserted(studentList.size)

                edtName.text.clear()
                edtAge.text.clear()
            }

        }


    }
}