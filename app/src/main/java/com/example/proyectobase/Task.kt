package com.example.proyectobase

import android.widget.ImageView
import com.google.gson.annotations.Expose
import java.sql.Time

data class TasK(
    @Expose var title: String,
    @Expose var description: String,
    @Expose var state: String,
    @Expose var time: String,
    @Expose var date: String,
    @Expose var icon: Int = R.drawable.icon_elephant,
    @Expose val background: Int = R.drawable.cc0400_color //Imagen predeterminada

)