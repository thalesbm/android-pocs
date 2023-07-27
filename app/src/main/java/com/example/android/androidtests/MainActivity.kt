package com.example.android.androidtests

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.android.workmanager.WorkManagerActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<AppCompatButton>(R.id.buttonWorkManager)
        button.setOnClickListener {
            val intent = Intent(this, WorkManagerActivity::class.java)
            startActivity(intent)
        }
    }
}
