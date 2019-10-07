package com.core.kotlin

import com.core.kotlin.http.Data
import com.core.kotlin.http.Dato

class Model : MVP.Model {

     var repositorio: Repositorio
     var presenter:Presenter



    constructor(presenter: Presenter){
        this.presenter= presenter
        this.repositorio=Repositorio()
    }


    override fun onLoad(query:String) {


        repositorio.RetrofitData(query)
        presenter.Response()


    }
    override fun Response(): ArrayList<Dato> {


            return repositorio.getData()

    }


}