package com.example.advancedkotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat


// Context
fun Context.createNotification(id: Int, channelId: String = "") {
    val builder = NotificationCompat.Builder(this, channelId)
        .setContentTitle("Title")
        .setSmallIcon(R.drawable.notification_icon)
        .setContentText("This is my notification")

    val notificationManager =
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "Google"
        val descriptionText = "description"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(channelId, name, importance)
        channel.description = descriptionText

        notificationManager.createNotificationChannel(channel)
    }
        notificationManager.notify(0, builder.build())


}