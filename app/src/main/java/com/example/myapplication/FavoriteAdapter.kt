package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.favorite_dish_row.view.*

class FavoriteAdapter(private var disheslist:MutableList<Dish>):
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>()
{
    lateinit var listener: DeleteBtnListener
    lateinit var itemClickListener: DishesAdapter.DishListItemClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.favorite_dish_row,parent,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.init(disheslist[position])
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClicked(position,disheslist[position])
        }
        holder.itemView.deleteBtn.setOnClickListener {
            listener.deleteBtnClicked(position,disheslist[position])
        }
    }

    override fun getItemCount(): Int {
        return disheslist.size
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        @SuppressLint("ResourceAsColor")
        fun init(dish: Dish){
            itemView.apply {
                findViewById<TextView>(R.id.nameFv).text = dish.name
                findViewById<TextView>(R.id.ratingFv).text = dish.rating.toString()
                findViewById<ImageView>(R.id.imageViewFv).setImageResource(dish.imageView)
            }
        }
    }

    interface DeleteBtnListener{
        fun deleteBtnClicked(position: Int,dish: Dish)
    }
}