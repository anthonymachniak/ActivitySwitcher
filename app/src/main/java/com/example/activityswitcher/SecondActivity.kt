package com.example.activityswitcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val message = intent.getStringExtra(ACTIVITY_MESSAGES)

        val textView = findViewById<TextView>(R.id.txtSavedText2).apply {
            text = message
        }
    }
}
