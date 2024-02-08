package com.example.m1lesson57roomrelation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.m1lesson57roomrelation.database.entity.Region
import com.example.m1lesson57roomrelation.databinding.ItemRegionBinding

class RegionAdapter(private val list: ArrayList<Region>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return list[position].id
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemRegionBinding =
            ItemRegionBinding.inflate(LayoutInflater.from(parent?.context), parent, false)

        itemRegionBinding.regionNameTv.text = list[position].name

        return itemRegionBinding.root
    }
}