package com.core.kotlin

import android.app.DownloadManager
import com.core.kotlin.http.Data
import com.core.kotlin.http.Dato
import retrofit2.Call

public interface MVP {

    interface View{

        fun getData():String
        fun setData(data: String)

        fun onError(error:String)
        fun onShow(data : ArrayList<Dato>)
        fun upDate()


    }

    interface  Presenter{

        fun  setView( view :MVP.View)
        fun Response ()
        fun onClick()


    }

    interface  Model{

        fun onLoad(query:String)
        fun Response():ArrayList<Dato>
    }


    interface MemoryRepositio{


        fun RetrofitData(query: String)
        fun getData():ArrayList<Dato>
    }
}