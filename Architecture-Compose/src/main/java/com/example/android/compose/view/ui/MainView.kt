package com.example.android.compose.view.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.compose.viewModel.MainViewModel

@Composable
fun Init(viewModel: MainViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        var textFieldValue by remember { mutableStateOf(String()) }

        val coroutineScope = rememberCoroutineScope()
        val messages = viewModel.viewLiveData.observeAsState()

        viewModel.getTitle()
        textFieldValue = String()

//        coroutineScope.launch {
//            viewModel.getTitle()
//        }

        Greeting(textFieldValue)

        messages.value?.let {

        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArchitectureTheme {
        Greeting("Android")
    }
}
