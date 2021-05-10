package com.example.proyectobase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {

    val taskWelcome = TasK("Instalar Gestiork", "termina la instalacion de Gestiork para comenzar a organizar tu día", "done",  R.drawable.icon_elephant )
    val taskIntro = TasK("Familiarizarte con la app :D", "Ve a curiosear por las distintas pantallas que Gestiork ofrece", "undone", R.drawable.icon_elephant )
    val proyectoFinal = TasK("Final de Progra III", "Preparate para la expo y rompela con todo", "doing", R.drawable.icon_elephant )


    var TasksList = mutableListOf<TasK>(taskWelcome, taskIntro, proyectoFinal)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)


        val listTitle = intent.getStringExtra("listTitle")


        textViewListName.text = listTitle

        textViewBienvenida.text = "Welcome :D"



        val adapter = TaskListRecyclerViewAdapter(TasksList)
        RecyclerViewTasks.adapter = adapter
        RecyclerViewTasks.layoutManager = GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false)




    }
}