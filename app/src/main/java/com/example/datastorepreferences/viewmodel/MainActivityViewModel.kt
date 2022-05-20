package com.example.datastorepreferences.viewmodel

import android.app.Application
import android.content.Context
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.datastorepreferences.datastorePref.DataStorePref
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application):AndroidViewModel(application) {
     private val datastore =  DataStorePref(application)
     val name_response = MutableLiveData<String?>()

    fun setPrefData(name:String){
        viewModelScope.launch(Dispatchers.IO) {
           // Log.i("EditText",name)
            datastore.setValue(name)
        }
    }

    fun get() =
        viewModelScope.launch(Dispatchers.IO) {
            datastore.getValue().collect {
                name_response.postValue(it)
               // it?.let { it1 -> Log.i("EditText", it1) }
            }
        }
}