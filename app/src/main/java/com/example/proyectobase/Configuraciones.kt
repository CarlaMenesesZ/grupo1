package com.example.proyectobase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_configuraciones.*

class Configuraciones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuraciones)

        bttContactanos.setOnClickListener{
            val intent = Intent(this, Contactanos:: class.java)
            startActivity(intent)
        }

        bttInformacion.setOnClickListener{
            val intent = Intent(this, Informacion:: class.java)
            startActivity(intent)
        }



    }
}