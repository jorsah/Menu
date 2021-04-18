package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dish_row.view.*

class DishesAdapter(var dishesList:MutableList<Dish>) :
    RecyclerView.Adapter<DishesAdapter.ViewHolder>() {

    lateinit var listener: DishListItemClickListener
    lateinit var btnListener: FavoriteButtonListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.dish_row,parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: DishesAdapter.ViewHolder, position: Int) {
        holder.init(dishesList[position],position)
        holder.itemView.setOnClickListener{
            listener.onItemClicked(position,dishesList[position])
        }
        holder.itemView.favoriteBtn.setOnClickListener {
            btnListener.onButtonClicked(position,dishesList[position])
            holder.itemView.favoriteBtn.setBackgroundColor(R.color.design_default_color_primary)
        }
    }

    override fun getItemCount(): Int {
        return dishesList.size
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        @SuppressLint("ResourceAsColor")
        fun init(dish:Dish, position: Int){
            itemView.apply {
                findViewById<TextView>(R.id.name).text = dish.name
                findViewById<TextView>(R.id.rating).text = dish.rating.toString()
                findViewById<ImageView>(R.id.imageView).setImageResource(dish.imageView)
                favoriteBtn.setOnClickListener {
                    favoriteBtn.setBackgroundColor(R.color.black)
                }
            }
        }
    }

    interface DishListItemClickListener{
        fun onItemClicked(position: Int,dish: Dish)
    }
    interface FavoriteButtonListener{
        fun onButtonClicked(position: Int,dish: Dish)
    }

}