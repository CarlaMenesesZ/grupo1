package com.example.proyectobase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_configuraciones2.*

class ConfiguracionesActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuraciones2)
        textContactanos.setOnClickListener{
            val intent = Intent(this, ContactanosActivity:: class.java)
            startActivity(intent)
        }


        textInformacion.setOnClickListener {
            val intent= Intent(this, InformacionActivity:: class.java)
            startActivity(intent)
        }
    }
}