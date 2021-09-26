package com.gc.personsapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gc.personsapp.data.Person
import com.gc.personsapp.data.PersonsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api : PersonsApi
) : ViewModel(){

    private val _state = mutableStateOf(PersonState())
      val state : State<PersonState> = _state


    init {
        getRandomPerson()
        }

    fun getRandomPerson(){
        viewModelScope.launch {
            try{
               _state.value = _state.value.copy(isLoading = true)
                _state.value = _state.value.copy(
                    person = api.getRandomPerson(),
                    isLoading = false
                )

            }catch (ex : Exception){
                Log.e("MainViewModel","getRandomPerson :",ex)
            }
        }

    }


    data class PersonState(
        val person : Person? = null,
        val isLoading: Boolean = false
    )
}