package com.core.kotlin

import com.core.kotlin.http.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
import com.core.kotlin.http.Data
import com.core.kotlin.http.Dato
import com.core.kotlin.http.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.R.attr.data
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Movie




class Repositorio : MVP.MemoryRepositio{




    var dataList = ArrayList<Dato>()
   // var dataList = ArrayList<Dato>()


    override fun RetrofitData(query: String) {


        var data = ArrayList<Dato>()
        RetrofitClient.url.getMovie(query.trim()).enqueue(object: Callback<List<Dato>> {

            override fun onResponse(call: Call<List<Dato>>, response: Response<List<Dato>>){

                data = response.body() as ArrayList<Dato>

                try {

                    dataList = response.body() as ArrayList<Dato>

                }catch ( e :Exception){

                    Log.e("TAG" , e.toString())
                }

              //si esta pasando datos
              Log.d("XA" , response.message())

            }

            override fun onFailure(call: Call<List<Dato>>, t: Throwable) {
                t.printStackTrace()
            }
        })



    }
    override fun getData():ArrayList<Dato> {

        val data = dataList


        return data

    }






}
