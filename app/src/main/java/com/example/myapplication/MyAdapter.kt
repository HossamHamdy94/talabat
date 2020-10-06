package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemBinding

class MyAdapter(private val list: List<ListItem>) :
    RecyclerView.Adapter<MyAdapter.ExampleViewHolder>() {

    var listList= listOf<ListItem> ()
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        return ExampleViewHolder.from(parent)
    }

    override fun onBindViewHolder (holder: ExampleViewHolder, position: Int) {
        val currentItem = list[position]
        holder.bind(currentItem)

    }
    override fun getItemCount() = list.size

    class ExampleViewHolder private  constructor(val binding:  ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: ListItem,
            ) {
            binding.itemImageview.setImageResource(item.imageResource)
            binding.title.text = item.title
            binding.time.text = item.time
           binding.time.text = item.time
            binding.gender.text = item.gender
            binding.number.text = item.Number
            binding.type.text = item.type
        }


        companion object {
             fun from(parent: ViewGroup): ExampleViewHolder {
                 val layoutInflater = LayoutInflater.from(parent.context)

                 val binding = ListItemBinding.inflate(layoutInflater,parent,false)
                return ExampleViewHolder(binding)
            }
        }

    }
    class SleepNightDiffCallback : DiffUtil.ItemCallback<ListItem>() {
        override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem.time == newItem.time
        }

        override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem == newItem
        }
    }


}