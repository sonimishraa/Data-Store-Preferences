package com.example.datastorepreferences.datastorePref

import android.content.Context
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.map

open class DataStorePref(context: Context) {
    private val dataStore = context.createDataStore(DataStorePref::class.java.simpleName)
    companion object{
        val name_key = preferencesKey<String>("name")
    }

    suspend fun setValue(name:String){

        dataStore.edit {
           it[name_key] = name
        }
    }

    suspend fun getValue() =
        dataStore.data.map {
            it[name_key]
        }
}