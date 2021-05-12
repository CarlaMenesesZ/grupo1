package com.example.proyectobase

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_perfil.*
import java.io.File

class PerfilActivity : AppCompatActivity() {
    val requestCodeGallery = 123
    val requestCodeCamera = 456
    var fileUri: Uri?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        val user= TemporalStorage.usuario!!
        val correo = TemporalStorage.usuario!!


        textViewNombrePerfil.text = (user.username)

        textView7.setOnClickListener {
            val intent = Intent(this, Configuraciones::class.java)
            startActivity(intent)
        }

        textViewCorreo.text= correo.correo
        //imageAvatarPerfil.setImageURI(user.imageUri!!)

        switchNotificacion.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Canal general de notificaciones"
                val descriptionText = "Tareas y alertas"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val mChannel = NotificationChannel(idCanalNotificaciones, name, importance)
                mChannel.description = descriptionText
                val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(mChannel)
            }

            val notificationIntent = Intent(this, MainMenuActivity::class.java)

            val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)

            val builder = NotificationCompat.Builder(this, idCanalNotificaciones)
                .setSmallIcon(R.drawable.icon_plus)
                .setContentTitle("Tienes una tarea pendiente!")
                .setContentText("Investigacion de Progra 3 .......")
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)


            with(NotificationManagerCompat.from(this)) {
                notify(Math.floor(Math.random() * 1000).toInt(), builder.build())
            }

        }
        imageViewCamara.setOnClickListener{
            val file = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),"imageCamera" + System.currentTimeMillis() + ".jpg")
        fileUri = FileProvider.getUriForFile(this, "com.example.proyectobase", file)

        val intent = Intent()
        intent.action = MediaStore.ACTION_IMAGE_CAPTURE
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
        startActivityForResult(intent, requestCodeCamera)
    }
        imageViewGallery.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
            startActivityForResult(Intent.createChooser(intent, "Selecciona una imagen!"), requestCodeGallery)

        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == requestCodeGallery) {
            imageAvatarPerfil.setImageURI(data?.data)
            fileUri = data?.data
        } else if(requestCode == requestCodeCamera) {
            imageAvatarPerfil.setImageURI(fileUri)
        }
    }

    companion object {
        const val idCanalNotificaciones = "1234"
    }
}