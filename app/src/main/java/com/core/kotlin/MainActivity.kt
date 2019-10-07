package com.core.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import com.core.kotlin.http.Dato
import androidx.recyclerview.widget.DefaultItemAnimator





class MainActivity : AppCompatActivity(), MVP.View {



    lateinit var presenter: Presenter
    lateinit var adaptador: Adaptador
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = Presenter(this)
        editText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable) {


                    presenter.onClick()

            }
        })


        /* var data = ArrayList<Dato>()
        RetrofitClient.url.getMovie(editText.text.toString().trim()).enqueue(object: Callback<List<Dato>> {

            override fun onResponse(call: Call<List<Dato>>, response: Response<List<Dato>>){

                if(response.isSuccessful){

                    // dataList.add(datos)

                    data = response.body() as ArrayList<Dato>

                }

            }

            override fun onFailure(call: Call<List<Dato>>, t: Throwable) {
                t.printStackTrace()
            }
        })*/


    }

    override fun onResume() {
        super.onResume()

        presenter.setView(this)
    }

    override fun getData(): String {

        return this.editText.text.toString()
    }


    override fun setData(data: String) {

        this.editText.text.toString()

    }


    override fun onShow(data: ArrayList<Dato>) {



            adaptador = Adaptador( this,data)
            reciclerview.setHasFixedSize(true)



            reciclerview.apply {


                adaptador.notifyDataSetChanged()
                reciclerview.setItemAnimator(DefaultItemAnimator())

                layoutManager = LinearLayoutManager(this@MainActivity)

                adapter = adaptador



                //data.clear()
            }








    }
    override fun onError(error: String) {

        Toast.makeText(this,error,Toast.LENGTH_LONG).show()
        editText.setError("")
    }


    override fun upDate() {


    }
}

