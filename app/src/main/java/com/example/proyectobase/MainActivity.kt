package com.example.proyectobase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        SignInFacebook.setOnClickListener{

            val intent = Intent(this, ConfiguracionesActivity2::class.java)
            startActivity(intent)
        }

        SignInGoogle.setOnClickListener {

            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }

        SignInEmail.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }




    }
}