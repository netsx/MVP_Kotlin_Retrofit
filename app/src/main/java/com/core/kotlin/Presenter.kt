package com.core.kotlin

import com.core.kotlin.http.Data


class Presenter :MVP.Presenter {



    private var vista: MVP.View
    private var model: MVP.Model



    constructor(vista:MVP.View) {

        this.model = Model(this)
        this.vista =vista


    }


    override fun setView(view: MVP.View) {

        this.vista =view

    }

    override fun onClick() {


        if(vista!= null){

            if(vista.getData().isEmpty()){

                vista.onError("Campo requerido")

            }else{


                model.onLoad(vista.getData())

            }
        }

    }


    override fun Response() {

            vista.onShow(model.Response())
    }



}