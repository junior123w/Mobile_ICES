package com.example.week10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week10.databinding.TextRowItemBinding


class FirstAdapter(private var dataSet: List<Movie>) :
    RecyclerView.Adapter<FirstAdapter.ViewHolder>()
{
    var onMovieClick: ((Movie)-> Unit)? = null

    class ViewHolder(val binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder
    {
        // Inflate the layout with view binding
        val binding = TextRowItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int)
    {
        // Use view binding to set the text
        viewHolder.binding.title.text = dataSet[position].title
        viewHolder.binding.studio.text = dataSet[position].studio

        viewHolder.binding.root.setOnClickListener{
            onMovieClick?.invoke(dataSet[position])
        }
    }

    override fun getItemCount() = dataSet.size
}