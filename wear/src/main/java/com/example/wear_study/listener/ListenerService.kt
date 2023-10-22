package com.example.wear_study.listener

import android.content.Intent
import android.util.Log
import com.example.wear_study.presentation.MainActivity
import com.google.android.gms.wearable.MessageEvent
import com.google.android.gms.wearable.WearableListenerService

class ListenerService : WearableListenerService()  {
    override fun onMessageReceived(messageEvent: MessageEvent) {
        super.onMessageReceived(messageEvent)
        Log.d("WearApp", "Message received, path: ${messageEvent.path}")
        if (messageEvent.path == "/start-wear-app") {
            val startIntent = Intent(this, MainActivity::class.java)
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(startIntent)
        }
    }
}