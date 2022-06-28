package com.rkqnt.oauth2test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OAuth2modularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oauth2modular)

        val cognitoBtn = findViewById<Button>(R.id.cognitomodule)
        cognitoBtn.setOnClickListener {
            startActivity(Intent(applicationContext,CognitoActivity::class.java))
        }
    }
}