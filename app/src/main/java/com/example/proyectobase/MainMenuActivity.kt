package com.example.proyectobase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

    val usernameRecibido = intent.getStringExtra("username")
    val passwordnameRecibido = intent.getStringExtra("password")

        val user = intent.getSerializableExtra("user") as Usuario

        textViewBienvenida.text = "Welcome " + (user.username) + " :D"

        imageButtonAddListofTasks.setOnClickListener {

        }
    }
}