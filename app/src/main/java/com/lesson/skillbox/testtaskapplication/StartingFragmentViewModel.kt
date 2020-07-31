package com.lesson.skillbox.testtaskapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class StartingFragmentViewModel : ViewModel() {

    private val repo = Repository


    init {
        repo.getData()
    }

    fun getUrl(): LiveData<String> {
        return repo.getUrl()
    }


}