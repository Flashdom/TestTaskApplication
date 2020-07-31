package com.lesson.skillbox.testtaskapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lesson.skillbox.testtaskapplication.repository.Repository

class StartingFragmentViewModel : ViewModel() {

    private val repo =
        Repository


    init {
        Repository.getData()
    }

    fun getUrl(): LiveData<String> {
        return Repository.getUrl()
    }


}