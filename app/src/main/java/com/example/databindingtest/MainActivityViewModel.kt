package com.example.databindingtest

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    val showContainer = ObservableBoolean(false)

    fun showCustomWidgetClick() {
        showContainer.set(true)
    }
}