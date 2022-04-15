package com.noni.recyclerviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SuperheroAdapter(private val context: Context, private val superhero:List<Superhero>, val listener: (Superhero) -> Unit)
    : RecyclerView.Adapter<SuperheroAdapter.SuperheroViewholder>(){


    class SuperheroViewholder(view: View): RecyclerView.ViewHolder(view) {
        val imgSuperhero = view.findViewById<ImageView>(R.id.img_item_photo)
        val nameSuperhero = view.findViewById<TextView>(R.id.tv_item_name)
        val descSuperhero = view.findViewById<TextView>(R.id.tv_item_description)

        fun bindview(superhero: Superhero, listener: (Superhero) -> Unit){
            imgSuperhero.setImageResource(superhero.imgSuperhero)
            nameSuperhero.text = superhero.nameSuperhero
            descSuperhero.text = superhero.descSuperhero
            itemView.setOnClickListener {
                listener(superhero)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewholder {
        return SuperheroViewholder(
            LayoutInflater.from(context).inflate(R.layout.item_superhiro, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SuperheroViewholder, position: Int) {
        holder.bindview(superhero[position], listener)
    }

    override fun getItemCount(): Int = superhero.size
    }