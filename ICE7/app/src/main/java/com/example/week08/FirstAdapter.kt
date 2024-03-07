package com.example.week08

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week08.databinding.TextRowItemBinding

class FirstAdapter(private val dataSet: Array<TVShow>) :
    RecyclerView.Adapter<FirstAdapter.ViewHolder>() {
    class ViewHolder(val binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the layout with view binding
        val binding = TextRowItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Use view binding to set the text
        viewHolder.binding.title.text = dataSet[position].title
        viewHolder.binding.studio   .text = dataSet[position].studio
    }
    override fun getItemCount() = dataSet.size
}