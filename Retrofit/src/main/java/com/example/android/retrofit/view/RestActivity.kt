package com.example.android.retrofit.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.android.retrofit.R
import com.example.android.retrofit.repository.RestRepository
import com.example.android.retrofit.viewModel.RestViewModel

class RestActivity : AppCompatActivity() {

    private val viewModel = RestViewModel(RestRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val button = findViewById<Button>(R.id.button3)
        button.setOnClickListener {
            callRest()
        }

        val response = findViewById<TextView>(R.id.response)
        viewModel.getCustomObservable().observe(this, Observer { item ->
            response.text = item.userModel.firstName
        })

        viewModel.getCustomStringObservable().observe(this, Observer { item ->
            response.text = item
        })
    }

    private fun callRest() {
        viewModel.callRepository()
    }
}
