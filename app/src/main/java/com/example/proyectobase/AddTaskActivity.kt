package com.example.proyectobase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_add_task.*
import kotlinx.android.synthetic.main.activity_details_task.*
import kotlinx.android.synthetic.main.activity_details_task.view.*
import kotlinx.android.synthetic.main.icons_list.*



class AddTaskActivity : AppCompatActivity() {

    var task_icon:Int = R.drawable.icon_elephant
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)



        val state_list = listOf("Undone", "Doing", "Done")
        spinnerState.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, state_list)

        floatingActionButtonAdd_Task.setOnClickListener{
            val new_Task = TasK(editTextTextTitle.text.toString(), editTextTextDescription.text.toString(), spinnerState.selectedItem.toString(),editTextTime2Time_.text.toString(),editTextDateDate_.text.toString(),task_icon)
            TemporalStorage.taskList.add(new_Task)
            finish()
        }
        
        imageViewIcon_.setOnClickListener {


            val alertDialog = AlertDialog.Builder(this).setView(R.layout.icons_list).create()
            alertDialog.show()

           alertDialog.findViewById<ImageView>(R.id.imageViewApple)!!.setOnClickListener {
                task_icon = R.drawable.apple_icon
               imageViewIcon_.setImageResource(task_icon)
                alertDialog.dismiss()

            }
            alertDialog.findViewById<ImageView>(R.id.imageViewAndroid)!!.setOnClickListener {
                task_icon = R.drawable.android
                imageViewIcon_.setImageResource(task_icon)
                alertDialog.dismiss()

            }
            alertDialog.findViewById<ImageView>(R.id.imageViewPlume)!!.setOnClickListener {
                task_icon = R.drawable.icon_plume
                imageViewIcon_.setImageResource(task_icon)
                alertDialog.dismiss()

            }
            alertDialog.findViewById<ImageView>(R.id.imageViewTrashcan)!!.setOnClickListener {
                task_icon = R.drawable.icon_trash
                imageViewIcon_.setImageResource(task_icon)
                alertDialog.dismiss()
            }
            alertDialog.findViewById<ImageView>(R.id.imageViewTask)!!.setOnClickListener {
                task_icon = R.drawable.icon_edite
                imageViewIcon_.setImageResource(task_icon)
                alertDialog.dismiss()
            }
            alertDialog.findViewById<ImageView>(R.id.imageView7plus)!!.setOnClickListener {
                task_icon = R.drawable.icon_plus
                imageViewIcon_.setImageResource(task_icon)
                alertDialog.dismiss()
            }
        }
    }
}