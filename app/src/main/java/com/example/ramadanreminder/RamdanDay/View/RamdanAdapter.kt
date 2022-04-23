package com.example.ramadanreminder.RamdanDay.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ramadanreminder.R

class RamdanAdapter (var context: Context , var onDayClick: onDayClick) : RecyclerView.Adapter<RamdanAdapter.RamdanHandler>() {
    var days = listOf(
        "1 رمضان" ,"2 رمضان","3 رمضان","4 رمضان", "5 رمضان" ,"6 رمضان" ,"7 رمضان","8 رمضان", "9 رمضان", "10 رمضان",
        "11 رمضان" ,"12 رمضان","13 رمضان","14 رمضان", "15 رمضان" ,"16 رمضان" ,"17 رمضان","18 رمضان", "19 رمضان", "20 رمضان",
        "21 رمضان" ,"22 رمضان","23 رمضان","24 رمضان", "25 رمضان" ,"26 رمضان" ,"27 رمضان","28 رمضان", "29 رمضان", "30 رمضان",
    )

    class RamdanHandler (item:View ): RecyclerView.ViewHolder(item){
        val row =item
        val DAY: TextView = row.findViewById(R.id.day)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RamdanHandler {
        return RamdanHandler(LayoutInflater.from(parent.context).inflate(R.layout.customday,parent,false))
    }

    override fun onBindViewHolder(holder: RamdanHandler, position: Int) {
        holder.DAY.text=days.get(position)
        holder.row.setOnClickListener{
            onDayClick.onlick(position)
        }
    }

    override fun getItemCount(): Int { return days.size   }
}