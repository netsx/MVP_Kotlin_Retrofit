package com.core.kotlin

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.core.kotlin.http.Dato
import android.view.View.OnLongClickListener



class Adaptador(private  val context: Context,private val datos: ArrayList<Dato>) :
    RecyclerView.Adapter<Adaptador.ViewHolder>() {


    override fun getItemCount(): Int {
        return datos.size
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): Adaptador.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.tarjeta, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: ViewHolder, position: Int) {


        //viewHolder.textView.setText(categorias.get(i).)
        try {

            holder.htextView.text=datos.get(position).show.name;
            Glide.with(context)
                .load(datos.get(position).show.image.medium)
                .thumbnail(0.5f)

                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.himageView);


        }catch (e :Exception){

            Log.e("TAG", e.toString())
        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
         {

        var htextView:TextView =itemView!!.findViewById(R.id.title)
        var himageView:ImageView = itemView!!.findViewById(R.id.thumbnail)

     //   private val textView: TextView
       // private val imageView: ImageView


        init {


          //  textView = view.findViewById(R.id.title) as TextView
           // imageView = view.findViewById(R.id.thumbnail) as ImageView

            view.setOnClickListener(View.OnClickListener {
                Toast.makeText(context,""+datos.get(adapterPosition).show.id,Toast.LENGTH_LONG).show()

            })
            view.setOnLongClickListener(OnLongClickListener {
                Toast.makeText(context,""+datos.get(adapterPosition).show.name,Toast.LENGTH_LONG).show()
                true
            })
           // view.setOnClickListener(this)
        }




    }


}
