package com.lesson.skillbox.testtaskapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lesson.skillbox.testtaskapplication.repository.network.Api
import com.lesson.skillbox.testtaskapplication.repository.network.models.Model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object Repository {

    private val api =
        Api.create()
    private val url = MutableLiveData<String>()

    fun getData() {
        api.getData("2ottk6qvq3n63jec38t8").enqueue(object : Callback<Model> {
            override fun onFailure(call: Call<Model>, t: Throwable) {
                error("Something went wrong")

            }

            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                val model = response.body()
                if (model?.url == null)
                    url.value = "noUrl"
                else
                    url.value = model.url

            }
        })


    }

    fun getUrl(): LiveData<String> {
        return url
    }

}