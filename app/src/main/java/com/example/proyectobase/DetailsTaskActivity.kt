package com.example.proyectobase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_details_task.*

class DetailsTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_task)

        val task = Gson().fromJson(intent.getStringExtra("task"), TasK::class.java)

        textViewTitle.text = task.title
        textViewDescription.text = task.description
        textViewState.text = task.state
        imageViewIconDetail.setImageResource(task.icon)
    }
}