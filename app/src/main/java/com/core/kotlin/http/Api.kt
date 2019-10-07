package com.core.kotlin.http

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {


    @GET("/search/shows")
    fun getMovie(@Query("q")datas:String):Call<List<Dato>>



}