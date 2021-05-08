package com.example.proyectobase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {

    val taskWelcome = TasK("Instalar Gestiork", "termina la instalacion de Gestiork para comenzar a organizar tu día", R.drawable.cc0400_color )
    val taskIntro = TasK("Familiarizarte con la app :D", "Ve a curiosear por las distintas pantallas que Gestiork ofrece", R.drawable.cc0400_color)

    var TasksList = mutableListOf<TasK>(taskWelcome, taskIntro)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

    val usernameRecibido = intent.getStringExtra("username")
    val passwordnameRecibido = intent.getStringExtra("password")

        val user = intent.getSerializableExtra("user") as Usuario

        textViewBienvenida.text = "Welcome " + (user.username) + " :D"


        RecyclerViewTasks.adapter = TaskListRecyclerViewAdapter(TasksList)
        RecyclerViewTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        floatingActionButtonAddList.setOnClickListener{

            textViewListName.text = editTextTextListName.text
            ConstraintLayoutTemporal.visibility = View.GONE

        }

        imageViewAvatar.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        }
    }


}