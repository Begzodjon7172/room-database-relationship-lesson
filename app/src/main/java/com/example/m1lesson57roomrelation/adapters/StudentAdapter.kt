package com.example.m1lesson57roomrelation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.m1lesson57roomrelation.databinding.ItemStudentBinding
import com.example.m1lesson57roomrelation.models.StudentWithRegion

class StudentAdapter(private val list: ArrayList<StudentWithRegion>) :
    RecyclerView.Adapter<StudentAdapter.Vh>() {

    inner class Vh(private val itemStudentBinding: ItemStudentBinding) :
        RecyclerView.ViewHolder(itemStudentBinding.root) {
        fun onBind(studentWithRegion: StudentWithRegion) {
            itemStudentBinding.tvName.text = studentWithRegion.student.name
            itemStudentBinding.tvAge.text = studentWithRegion.student.age.toString()
            itemStudentBinding.tvRegionName.text = studentWithRegion.region.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}