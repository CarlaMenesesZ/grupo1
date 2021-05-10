package com.example.proyectobase

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        // val usernameRecibido = intent.getStringExtra("username")
        // val correonameRecibido = intent.getStringExtra("correo")

        //val user = intent.getSerializableExtra("user") as Usuario
        textViewNombrePerfil.text = "Carla Meneses"//(user.username)
        // val correo= intent.getSerializableExtra("correo") as Usuario

        textViewCorreo.text= "Correoelectronico@gamil.com"//correo.correo

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



    }

    companion object {
        const val idCanalNotificaciones = "1234"
    }
}