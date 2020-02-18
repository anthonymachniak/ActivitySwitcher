package com.example.activityswitcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val message = intent.getStringExtra(ACTIVITY_MESSAGES)

        val textView = findViewById<TextView>(R.id.txtDisplaySavedText).apply {
            text = message
        }

        intent = Intent(this, MainActivity::class.java)

        var btnSaveText: Button = findViewById(R.id.btnSaveText2)
        var enterText: TextView = findViewById(R.id.enterText2)

        btnSaveText.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                saveText(enterText.text.toString())
            }
        })

        var btnSwitchActivity: Button = findViewById(R.id.btnSwitchToActivity1)

        btnSwitchActivity.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                changeScreen(intent)
            }
        })
    }

    fun saveText(textToSave: String) {
        intent = Intent(this, MainActivity::class.java).apply {
            putExtra(ACTIVITY_MESSAGES, textToSave)
        }

        var txtSavedText: TextView = findViewById(R.id.txtSavedText2)
        txtSavedText.text = textToSave
    }

    fun changeScreen(intent: Intent) {
        startActivity(intent)
    }
}
