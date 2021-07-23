package com.abdul.myfirsttap

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyService : Service(){
    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this,"service created",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"service destroyed",Toast.LENGTH_SHORT).show()

    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

}
