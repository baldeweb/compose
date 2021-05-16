package com.example.composejetpack.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejetpack.data.SWRepository
import kotlinx.coroutines.launch

class SWViewModel(private val repository: SWRepository) : ViewModel() {
    fun getPeople() {
        viewModelScope.launch {
            launch {
                val people = repository.getPeople()
                Log.d("LOG", "people: $people")
            }
        }
    }
}