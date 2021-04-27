package com.example.proyectobase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SignInFacebook.setOnClickListener{
            progressBarRegistro.visibility = View.VISIBLE
            progressBarRegistro.scrollBarFadeDuration
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }

        SignInGoogle.setOnClickListener {
            progressBarRegistro.visibility = View.VISIBLE
            progressBarRegistro.scrollBarFadeDuration
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }

        SignInEmail.setOnClickListener {
            progressBarRegistro.visibility = View.VISIBLE
            progressBarRegistro.scrollBarFadeDuration
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}