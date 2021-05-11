package com.example.proyectobase
import android.net.Uri
import com.google.gson.annotations.Expose
import java.io.Serializable

data class Usuario (
    @Expose val username: String,
    @Expose val password: String,
    @Expose val correo: String,
    @Expose val imageUri: Uri?): Serializable
