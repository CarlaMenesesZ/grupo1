package com.example.proyectobase

import android.content.Context
import android.net.Uri
import com.google.gson.GsonBuilder

class SharedPreferencesManager {
    val gson = GsonBuilder().registerTypeAdapter(Uri::class.java, UriAdapter()).create()

    fun crearUsuarioNuevo(context: Context, usuario: Usuario) {
        val usuarioExistente =
            obtenerUsuarios(context).find { usuarioRegistrado -> usuarioRegistrado.username == usuario.username }

        if(usuarioExistente == null) {
            val usuariosRegistrados = obtenerUsuarios(context).toMutableList()
            usuariosRegistrados.add(usuario)

            val usuariosRegistradosJson = gson.toJson(usuariosRegistrados)

            val prefs = context.getSharedPreferences("datos", Context.MODE_PRIVATE)
            val prefsEditor = prefs.edit()
            prefsEditor.putString("usuarios", usuariosRegistradosJson)
            prefsEditor.apply()
        }
    }

    fun obtenerUsuarios(context: Context): List<Usuario> {
        val prefs = context.getSharedPreferences("datos", Context.MODE_PRIVATE)
        val usuarioJson = prefs.getString("usuarios", null)
        if (usuarioJson != null) {
            val usuarios: List<Usuario> = gson.fromJson(usuarioJson)
            return usuarios
        } else {
            return listOf()
        }}
}