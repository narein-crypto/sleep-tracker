package com.example.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SleepViewModel (application: Application) : AndroidViewModel(application){
    private val sleepRepository: SleepRepository

    val sleepList : LiveData<List<Sleep>>

    init {
        val sleepDao = SleepDatabase.getDatabase(application).sleepDao()
        sleepRepository = SleepRepository(sleepDao)
        sleepList = sleepRepository.sleepList
    }
    //Execute a coroutine
    fun insertSleep(sleep: Sleep) = viewModelScope.launch {
        sleepRepository.insertSleep(sleep)

    }
}