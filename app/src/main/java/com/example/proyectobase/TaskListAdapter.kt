package com.example.proyectobase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class TaskListRecyclerViewAdapter(var TasksList: List<TasK>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.list_item_task, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(TasksList.get(position))
    }

    override fun getItemCount(): Int {
        return TasksList.size
    }



}

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(task: TasK){
        itemView.findViewById<TextView>(R.id.textViewTitleItem).text = task.title
        itemView.findViewById<ImageView>(R.id.imageViewBackgroundItem).setImageResource(task.background)
    }
}