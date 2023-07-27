package com.example.android.koin.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.koin.R
import com.example.android.koin.model.UserModel

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private val list by lazy {
        mutableListOf<UserModel>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_koin, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.textview.text = item.name
    }

    fun updateList(newList: List<UserModel>) {
        this.list.clear()
        this.list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textview: TextView = itemView.findViewById(R.id.adapterTextview)
    }
}