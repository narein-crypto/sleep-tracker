package com.example.sleeptracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class SleepAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<SleepAdapter.SleepViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var sleeps = emptyList<Sleep>() // Cached copy of words

    inner class SleepViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewQualityValue: TextView = itemView.findViewById(R.id.textViewQualityValue)
        val textViewStart : TextView = itemView.findViewById(R.id.textViewStartDateValue)
        val textViewEnd : TextView = itemView.findViewById(R.id.textViewEndDateValue)
    }

    override fun onBindViewHolder(holder: SleepViewHolder, position: Int) {
        val sleepRec:Sleep = sleeps.get(position)
        holder.textViewQualityValue.text = sleepRec.quality.toString()
        holder.textViewStart.text = SimpleDateFormat("yyyy,MM,dd,HH:MM").format(sleepRec.startDate)
        holder.textViewEnd.text = SimpleDateFormat("yyyy,MM,dd,HH:MM").format(sleepRec.endDate)
    }

    override fun getItemCount(): Int {
        return sleeps.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepViewHolder {

        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return SleepViewHolder(itemView)
    }

    fun setSleep(sleeps: List<Sleep>){
        this.sleeps = sleeps
        notifyDataSetChanged()
    }
}