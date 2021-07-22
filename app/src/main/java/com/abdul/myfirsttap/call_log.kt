package com.abdul.myfirsttap

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class call_log : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_log)
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS)
        !=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.READ_PHONE_NUMBERS),1)
        }
    }
}