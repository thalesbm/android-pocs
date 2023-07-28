package com.example.android.coroutines.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.android.coroutines.R
import com.example.android.coroutines.repository.CoroutinesRepository
import com.example.android.coroutines.viewModel.CoroutinesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.launch

class CoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

        val viewModel = CoroutinesViewModel(CoroutinesRepository())

        val count = findViewById<TextView>(R.id.count)
        viewModel.getCustomObservable().observe(this, Observer { item ->
            count.text = item.toString()
        })

        CoroutineScope(Default).launch {
            println(Thread.currentThread().name)
            viewModel.count()
        }
    }
}