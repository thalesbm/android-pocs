package com.example.android.mvvm.view.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.mvvm.domain.model.EmployerModel
import com.example.android.mvvm.domain.useCase.EmployerUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class EmployerViewModel(private val useCase: EmployerUseCase) : ViewModel(),
    CoroutineScope {

    private val TAG = EmployerViewModel::class::simpleName.name

    private val viewModelJob = SupervisorJob()
    private val state = MutableLiveData<EmployerState>()
    val viewState: LiveData<EmployerState> = state

    override val coroutineContext: CoroutineContext = Dispatchers.Main + viewModelJob

    fun saveEmployer(model: EmployerModel) {
        Log.d(TAG, "EmployerViewModel::saveEmployer()")
        launch {
            val isSaved = useCase.saveEmployer(model)
            if (isSaved) {

                state.value = EmployerState.ShowSuccessfulMessage
            } else {
                state.value = EmployerState.ShowUnsuccessfulMessage
            }
        }
    }
}
