package com.lesson.skillbox.testtaskapplication.repository.network

import com.lesson.skillbox.testtaskapplication.repository.network.models.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    @GET("cloaka.php/")
    fun getData(@Query("id") id: String): Call<Model>


    companion object {
        fun create(): Api = Retrofit.Builder()
            .baseUrl("http://platinum-kaz.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Api::class.java)


    }
}