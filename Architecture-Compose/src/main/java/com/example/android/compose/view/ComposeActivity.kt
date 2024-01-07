package com.example.android.compose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.android.compose.view.ui.ComposeArchitectureTheme
import com.example.android.compose.view.ui.Init
import com.example.android.compose.viewModel.MainViewModel

class ComposeActivity : ComponentActivity() {

    private val viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeArchitectureTheme {
                Init(viewModel)
            }
        }
    }
}
