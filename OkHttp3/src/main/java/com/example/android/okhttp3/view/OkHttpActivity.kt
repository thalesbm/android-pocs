package com.example.android.okhttp3.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.android.okhttp3.R
import com.example.android.okhttp3.repository.RestRepository
import com.example.android.okhttp3.viewModel.RestViewModel

class OkHttpActivity : AppCompatActivity() {

    private val viewModel = RestViewModel(RestRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)

        val button = findViewById<Button>(R.id.button3)
        button.setOnClickListener {
            callRest()
        }

        val response = findViewById<TextView>(R.id.response)
        viewModel.getCustomObservable().observe(this, Observer { item ->
            response.text = item
        })

        viewModel.getCustomStringObservable().observe(this, Observer { item ->
            response.text = item
        })
    }

    private fun callRest() {
        viewModel.callRepository()
    }
}
