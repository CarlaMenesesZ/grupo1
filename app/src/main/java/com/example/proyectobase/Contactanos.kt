package com.example.proyectobase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Contactanos : AppCompatActivity() {

    var btt : Button?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactanos)





        btt = findViewById(R.id.bttenviar)
        btt!!.setOnClickListener{ Toast.makeText(this,"Su mensaje fue enviado con exito, gracias por su preferencia", Toast.LENGTH_LONG).show() }
    }
}