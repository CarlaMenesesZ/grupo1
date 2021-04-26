package com.example.proyectobase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val validUsersList = listOf(
                Usuario("Juanchito", "12345"),
                Usuario("Pedro Picapiedra", "password"),
                Usuario("Julia", "qwerty")
        )
        buttonCreate.text= "Create"
         val username = editTextTextEmailAddress.text.toString()
        val password= editTextTextPassword.text.toString()
        for (user in validUsersList){
            if(user.username == username && user.password == password) {
                val intent = Intent(this, MainMenuActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("password", password)
                intent.putExtra("user", user)
                startActivity(intent)
                break
            } else {
                Toast.makeText(this, "Login Incorrecto!", Toast.LENGTH_LONG).show()
            }
        }}
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