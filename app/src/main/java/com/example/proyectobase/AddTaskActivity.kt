package com.example.proyectobase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_add_task.*
import kotlinx.android.synthetic.main.activity_details_task.view.*

class AddTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val state_list = listOf("Undone", "Doing", "Done")
        spinnerState.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, state_list)

        floatingActionButtonAdd_Task.setOnClickListener{
            val new_Task = TasK(editTextTextTitle.text.toString(), editTextTextDescription.text.toString(), spinnerState.selectedItem.toString(),editTextTime2Time_.text.toString(),editTextDateDate_.text.toString())
            TemporalStorage.taskList.add(new_Task)
            finish()
        }
    }
}