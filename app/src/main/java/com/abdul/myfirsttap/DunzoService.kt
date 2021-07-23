package com.abdul.myfirsttap
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
abstract class DunzoService : Service() {
    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this,"service created",Toast.LENGTH_SHORT).show()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        var data = intent?.getStringExtra("mykey")
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show()
        stopSelf()
        return START_STICKY
    }}