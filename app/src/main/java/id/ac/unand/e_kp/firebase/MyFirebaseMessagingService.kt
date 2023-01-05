package id.ac.unand.e_kp.firebase

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import id.ac.unand.e_kp.Home
import id.ac.unand.e_kp.R


class MyFirebaseMessagingService : FirebaseMessagingService() {
    private val channel_id = "contoh"
    private val notifId = 1

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("token", "tokennya adalah $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val notificationIntent = PendingIntent.getActivity(this, 0,
        Intent(this, Home::class.java), PendingIntent.FLAG_UPDATE_CURRENT)
        val a = message.notification?.title.toString()
        val b = message.notification?.body.toString()

        createNotificationChannel()

        Log.d("message", "message $a dan bodynya $b")
        showNotification(a, b)
    }

    fun showNotification (title: String, message: String){
        val builder = NotificationCompat.Builder(this, channel_id)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_mhs_selesai_kp)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .setContentIntent(notificationIntent)
//       val manager = NotificationManagerCompat.from(this)
//       manager.notify(222, builder.build())
        with(NotificationManagerCompat.from(this)){
            notify(1, builder.build())
        }
    }

    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "Notification title"
            val descriptionText = "Notification description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channel_id, name, importance).apply {
                description = descriptionText
            }
            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}