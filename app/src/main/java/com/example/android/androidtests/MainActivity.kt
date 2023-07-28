package com.example.android.androidtests

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.android.coroutines.view.CoroutinesActivity
import com.example.android.intent.HomeActivity
import com.example.android.koin.view.UserActivity
import com.example.android.retrofit.view.RestActivity
import com.example.android.workmanager.WorkManagerActivity
import java.lang.Class as Class1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<AppCompatButton>(R.id.WorkManager).setOnClickListener {
            go(WorkManagerActivity::class.java)
        }

        findViewById<AppCompatButton>(R.id.Intent).setOnClickListener {
            go(HomeActivity::class.java)
        }

        findViewById<AppCompatButton>(R.id.Koin).setOnClickListener {
            go(UserActivity::class.java)
        }

        findViewById<AppCompatButton>(R.id.Retrofit).setOnClickListener {
            go(RestActivity::class.java)
        }

        findViewById<AppCompatButton>(R.id.Coroutines).setOnClickListener {
            go(CoroutinesActivity::class.java)
        }
    }

    private fun <T> go(internalClass: Class1<T>) {
        val intent = Intent(this, internalClass)
        startActivity(intent)
    }
}
