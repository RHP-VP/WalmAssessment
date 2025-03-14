package com.rp.wmytestapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rp.wmytestapplication.R
import com.rp.wmytestapplication.models.CountryListData

class CountryListAdapter(val list: MutableList<CountryListData>) :
    RecyclerView.Adapter<CountryListAdapter.CountryListViewHolder>() {


    class CountryListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtCountryName: TextView = view.findViewById(R.id.txtCountryName)
        val txtRegion: TextView = view.findViewById(R.id.txtRegion)
        val txtCode: TextView = view.findViewById(R.id.txtCode)
        val txtCapital: TextView = view.findViewById(R.id.txtCapital)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListViewHolder {
        return CountryListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        )
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CountryListViewHolder, position: Int) {

//        holder.txtCountryName.text = list.get(position).name.trim()
//        holder.txtRegion.text = list.get(position).region.trim()
        holder.txtCountryName.text = list.get(position).name.trim() + ", " + list.get(position).region.trim()
        holder.txtCode.text = list.get(position).code.trim()
        holder.txtCapital.text = list.get(position).capital.trim()

    }
}