package com.example.advancedkotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Build
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_main.view.*


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

//RequestListener<Drawable>


fun ImageView.loadurl(url:String){
    Glide.with(this)
        .load(url)
        .onSuccess{
            println("worked")
        }
        .onFailure {
            println("i give up")
        }
        .into(this)


}

fun RequestBuilder<Drawable>.onFailure(onFailure: () -> Unit): RequestBuilder<Drawable>{

    this.addListener(object: RequestListener<Drawable> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            onFailure.invoke()
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            return false
        }

    })
    return this
}

fun RequestBuilder<Drawable>.onSuccess(onSuccess: () -> Unit): RequestBuilder<Drawable>{
    this.addListener(object: RequestListener<Drawable> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            onSuccess.invoke()
            return false
        }

    })
    return this

}






