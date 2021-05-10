package com.example.proyectobase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import java.util.zip.Inflater

class TaskListRecyclerViewAdapter(var TasksList: MutableList<TasK>): RecyclerView.Adapter<ViewHolder>() {

    var clickListener: ((task: TasK) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.list_item_task, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(TasksList.get(position))
        holder.itemView.setOnClickListener{
            clickListener?.invoke(TasksList.get(position))
        }

    }

    override fun getItemCount(): Int {
        return TasksList.size
    }

    fun setOnTaskItemListener(taskclickListener: (task: TasK ) -> Unit){
        clickListener = taskclickListener

    }

    fun addProduct(task: TasK){
        TasksList.add(task)
        notifyDataSetChanged()
    }



}

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(task: TasK){
        itemView.findViewById<TextView>(R.id.textViewTitleItem).text = task.title
        val radius = (itemView.context).resources.getDimensionPixelSize(R.dimen.corner_radius)

        Glide.with(itemView.context)
                .load(task.background)
                .transform(RoundedCorners(radius)).into(itemView.findViewById<ImageView>(R.id.imageViewBackgroundItem))
        itemView.findViewById<ImageView>(R.id.imageViewIcon).setImageResource((task.icon))
        //itemView.findViewById<ImageView>(R.id.imageViewState).setImageResource((task.state))
        if(task.state == "Undone"){
            itemView.findViewById<ImageView>(R.id.imageViewState).setImageResource(R.drawable.icon_exclamation)
        }
        else if(task.state == "Doing"){
            itemView.findViewById<ImageView>(R.id.imageViewState).setImageResource(R.drawable.icon_hand)
        }
        else if(task.state == "Done"){
            itemView.findViewById<ImageView>(R.id.imageViewState).setImageResource(R.drawable.icon_like)
        }
    }
}