package com.example.proyectobase

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_new_user.*
import kotlinx.android.synthetic.main.activity_perfil.*
import java.io.File

class NewUserActivity : AppCompatActivity() {
    val requestCodeGallery = 123
    val requestCodeCamera = 456
    val sharedPreferencesManager = SharedPreferencesManager()
    var fileUri: Uri?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)
        imageViewCamara2.setOnClickListener{
            val file = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),"imageCamera" + System.currentTimeMillis() + ".jpg")
            fileUri = FileProvider.getUriForFile(this, "com.example.proyectobase", file)

            val intent = Intent()
            intent.action = MediaStore.ACTION_IMAGE_CAPTURE
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
            startActivityForResult(intent, requestCodeCamera)
        }
        imageViewGallery2.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
            startActivityForResult(Intent.createChooser(intent, "Selecciona una imagen!"), requestCodeGallery)

        }

        buttonCrearUsuario.setOnClickListener {
            val usuarioAGuardar = Usuario(editTextUsername.text.toString(), editTextPassword.text.toString(),editTextCorreo.text.toString(), fileUri)
            sharedPreferencesManager.crearUsuarioNuevo(this, usuarioAGuardar)
            finish()
        }



    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == requestCodeGallery) {
            imageView5.setImageURI(data?.data)
            fileUri = data?.data
        } else if(requestCode == requestCodeCamera) {
            imageView5.setImageURI(fileUri)
        }
    }



}