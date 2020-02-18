package com.example.activityswitcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

const val ACTIVITY_MESSAGES = "AppDictionary"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSaveText : Button = findViewById(R.id.btnSaveText)
        var enterText : TextView = findViewById(R.id.enterText)

        if (intent != null) {
            val message = intent.getStringExtra(ACTIVITY_MESSAGES)

            val textView = findViewById<TextView>(R.id.txtSavedText).apply {
                text = message
            }
        }

        intent = Intent(this, SecondActivity::class.java)

        btnSaveText.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                saveText(enterText.text.toString())
            }
        })

        var btnSwitchActivity : Button = findViewById(R.id.btnSwitchActivity)

        btnSwitchActivity.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                changeScreen(intent)
            }
        })
    }

    fun saveText(textToSave: String) {
        intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(ACTIVITY_MESSAGES, textToSave)
        }

        var txtSavedText : TextView = findViewById(R.id.txtSavedText)
        txtSavedText.text = textToSave
    }

    fun changeScreen(intent : Intent) {
        startActivity(intent)
    }
}
