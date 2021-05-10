package com.example.proyectobase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        floatingActionButtonAdd_Task.setOnClickListener{
            val new_Task = TasK(editTextTextTitle.text.toString(), editTextTextDescription.text.toString(), editTextTextState.text.toString())
            TemporalStorage.taskList.add(new_Task)
            finish()
        }
    }
}