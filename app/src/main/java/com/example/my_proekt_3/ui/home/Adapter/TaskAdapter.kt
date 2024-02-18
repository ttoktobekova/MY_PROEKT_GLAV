package com.example.my_proekt_3.ui.home.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.my_proekt_3.Model.Task
import com.example.my_proekt_3.databinding.ItemTaskBinding

class TaskAdapter() : Adapter<TaskAdapter.TaskViewHolder>() {

    private val list = arrayListOf<Task>()
    @SuppressLint("NotifyDataSetChanged")
    fun addTask(task:Task){
        list.add(0,task)
notifyItemChanged(0)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])
    }


    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc
        }
    }
}