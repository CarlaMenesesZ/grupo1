package com.example.proyectobase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_contactanos2.*

class ContactanosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactanos2)

        buttonEnviar.setOnClickListener{ Toast.makeText(this,"Su mensaje fue enviado con exito, gracias por su preferencia", Toast.LENGTH_LONG).show()
        finish()
        }

    }
}