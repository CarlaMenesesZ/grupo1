package com.example.proyectobase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    val sharedPreferencesManager = SharedPreferencesManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonCreate.text= "Login"
        buttonCreate.setOnClickListener {

            val username = editTextTextEmailAddress.text.toString()
            val password= editTextTextPassword.text.toString()
            val validUsers= sharedPreferencesManager.obtenerUsuarios(this)
            for (validUser in validUsers) {
                if(validUser.username == username && validUser.password == password) {
                    TemporalStorage.usuario = validUser
                    val intent = Intent(this, AddList::class.java)
                    intent.putExtra("username", username)
                    intent.putExtra("password", password)
                    startActivity(intent)

                }else {Toast.makeText(this, "Login Incorrecto!", Toast.LENGTH_SHORT).show()}}
        }
        buttonRegistroNuevo.setOnClickListener {
            val intent= Intent(this, NewUserActivity::class.java)
            startActivity(intent)
        }




    }
        override fun onStart() {
            super.onStart()
            println("onStart MainActivity")
        }

        override fun onResume() {
            super.onResume()
            println("onResume MainActivity")
        }

        override fun onPause() {
            super.onPause()
            println("onPause MainActivity")
        }

        override fun onStop() {
            super.onStop()
            println("onStop MainActivity")
        }

        override fun onDestroy() {
            super.onDestroy()
            println("onDestroy MainActivity")
        }

        override fun onRestart() {
            super.onRestart()
            println("onRestart MainActivity")
        }

}