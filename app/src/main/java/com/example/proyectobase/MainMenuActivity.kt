package com.example.proyectobase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {

    val adapter = TaskListRecyclerViewAdapter(TemporalStorage.taskList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)


        val listTitle = intent.getStringExtra("listTitle")
        val user= TemporalStorage.usuario!!


        textViewListName.text = listTitle

        textViewBienvenida.text = "Welcome "+ user.username+ " :D"
        imageViewAvatar.setImageURI(user.imageUri!!)



        adapter.setOnTaskItemListener { task ->
            val intent = Intent(this, DetailsTaskActivity::class.java)
           intent.putExtra("task", Gson().toJson(task))
            startActivity(intent)
        }
        RecyclerViewTasks.adapter = adapter
        RecyclerViewTasks.layoutManager = GridLayoutManager(this,2, GridLayoutManager.HORIZONTAL,false)

        floatingActionButtonAddTask.setOnClickListener {
            val intent = Intent(this,AddTaskActivity::class.java)
            startActivity(intent)
        }
        imageViewAvatar.setOnClickListener {
            val intent = Intent(this,PerfilActivity::class.java)
            startActivity(intent)
        }
        chipCalendario.setOnClickListener {
            val intent= Intent(this,CalendarioActivity2::class.java)
            startActivity(intent)
        }


    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart Activity")
        adapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        println("onResume Activity")
    }

    override fun onStop() {
        super.onStop()
        println("onStop Activity")

    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy Activity")

    }

    override fun onPause() {
        super.onPause()
        println("onPause Activity")
    }
}