package com.abdul.myfirsttap.model

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log
import android.view.Gravity
import android.widget.Toast

class CallReciever: BroadcastReceiver() {
    var TAG = CallReciever::class.java.simpleName
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent!!.getStringExtra(TelephonyManager.EXTRA_STATE)==TelephonyManager.EXTRA_STATE_OFFHOOK)
        {showToastMsg(context!!,"Call started on the phone")}
        else if(intent!!.getStringExtra(TelephonyManager.EXTRA_STATE)==TelephonyManager.EXTRA_STATE_IDLE)
        {
            Log.i(TAG,"call has ended")
            showToastMsg(context!!,"call has ended...")
        }
        else if (intent!!.getStringExtra(TelephonyManager.EXTRA_STATE)==TelephonyManager.EXTRA_STATE_RINGING)
        {
            showToastMsg(context!!,"call is ringing...")
        }
    }
    private fun showToastMsg(c:Context, msg: String) {
        val toast = Toast.makeText(c,msg,Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER,0,0)
        toast.show()
    }
}