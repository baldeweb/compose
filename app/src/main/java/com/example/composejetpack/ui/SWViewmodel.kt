package com.example.composejetpack.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejetpack.data.SWRepository
import com.example.composejetpack.data.dto.PeopleDTO
import kotlinx.coroutines.launch

class SWViewModel(private val repository: SWRepository) : ViewModel() {
    private var _people = MutableLiveData<PeopleDTO>()
    var people : LiveData<PeopleDTO> = _people

    fun getPeople() {
        viewModelScope.launch {
            launch {
                val response = repository.getPeople()
                _people.postValue(response)
                Log.d("LOG", "people: $people")
            }
        }
    }
}