package com.jayway.syssla.view

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.provider.CalendarContract
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jayway.syssla.R
import com.jayway.syssla.model.Chore
import kotlinx.android.synthetic.main.card_layout.view.*

internal class ChoresListAdapter(private val list: List<Chore>) : RecyclerView.Adapter<ChoresListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoresListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ChoresListAdapter.ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(chore: Chore) {
            itemView.title.text = chore.title
            itemView.findViewById<CardView>(R.id.card).setCardBackgroundColor(chore.color)
            itemView.points.text = "${chore.points}p"
        }
    }
}