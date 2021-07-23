package com.abdul.myfirsttap

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class notification : AppCompatActivity() {

    private val channel_id = "channel_id_example_01"
    private val notificationId = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        createnotifchannel()
    }

    private fun createnotifchannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {

        }
    }
}
