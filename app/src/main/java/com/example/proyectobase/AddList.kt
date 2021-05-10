package com.example.proyectobase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_add_list.*

class AddList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_list)

        floatingActionButtonAddList.setOnClickListener{

            var ListTitle = editTextTextListName.text.toString()

            val intent = Intent(this, MainMenuActivity::class.java)
            intent.putExtra("listTitle", ListTitle)
            startActivity(intent)

        }
    }
}