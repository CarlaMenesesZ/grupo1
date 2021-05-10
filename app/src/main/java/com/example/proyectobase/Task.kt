package com.example.proyectobase

import android.widget.ImageView
import com.google.gson.annotations.Expose

data class TasK(
    @Expose var title: String,
    @Expose var description: String,
    @Expose var state: String,
    @Expose var icon: Int = R.drawable.icon_elephant, //Icono predeterminado
    @Expose val background: Int = R.drawable.cc0400_color //Imagen predeterminada
)