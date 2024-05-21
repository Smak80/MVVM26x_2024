package ru.smak.mvvm262_2024

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

//class MainViewModel(app: Application) : AndroidViewModel(app) {
class MainViewModel() : ViewModel() {

    private val f: Filter = Filter()

    var v1 by mutableStateOf("")
    var v2 by mutableStateOf("")

    fun changeV1(newValue: String){
        v1 = f.filterToInt(newValue)
    }

}