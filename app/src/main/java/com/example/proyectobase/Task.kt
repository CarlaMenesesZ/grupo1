package com.example.proyectobase

import android.widget.ImageView

data class TasK(val title: String, val description: String, var state: String, var icon: Int,
                val background: Int = R.drawable.cc0400_color //Imagen predeterminada
)