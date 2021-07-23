package com.abdul.myfirsttap

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_alarm.*
import java.util.*
import kotlinx.android.synthetic.main.activity_alarm.btn as btn1

class AlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        val channelId = "My_Channel_ID"
        createNotificationChannel(channelId)


        val intent = Intent(this,MainActivity::class.java)
        intent.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(this,0,intent,0)


        val buttonIntent = Intent(this,MyBroadcastReceiver::class.java)
        buttonIntent.apply {
            action = "Do Pending Task"
            putExtra("My Favorite Color","RED Color")
        }

        val buttonPendingIntent = PendingIntent.getBroadcast(this,0,buttonIntent,0)
        btn1.setOnCheckedChangeListener { _, isChecked ->
            //Toast.makeText(this, if(isChecked) "Alarm Mode ON" else "Alarm Mode OFF", Toast.LENGTH_SHORT).show()
            if(isChecked) {
                showNotification(channelId, pendingIntent, buttonPendingIntent)
            }
        }

       /* btn1.setOnClickListener{
            showNotification(channelId, pendingIntent, buttonPendingIntent)
        }*/
    }

    private fun showNotification(
        channelId: String,
        pendingIntent: PendingIntent?,
        buttonPendingIntent: PendingIntent?
    ) {
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_action_info)
            .setContentTitle("Title: API LEVEL " + Build.VERSION.SDK_INT)
            .setContentText("UUID: alarm001 ")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .addAction(R.drawable.ic_action_home, "Do Task", buttonPendingIntent)

        with(NotificationManagerCompat.from(this)) {
            notify(1, notificationBuilder.build())
        }
    }


    private fun createNotificationChannel(channelId:String) {
        // Create the NotificationChannel, but only on API 26+ (Android 8.0) because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "My Channel"
            val channelDescription = "Channel Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(channelId,name,importance)
            channel.apply {
                description = channelDescription
            }

            // Finally register the channel with system
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    }

