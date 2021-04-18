package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_dishes_list.*

class DishesListFragment: Fragment() {
    private val dishesAdapter = DishesAdapter(dishes)
    lateinit var  listener:DishesListFragmentListener
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dishes_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dishes_recycler_view.layoutManager = LinearLayoutManager(context)
        dishes_recycler_view.adapter = dishesAdapter
        dishesAdapter.notifyDataSetChanged()

        dishesAdapter.listener = object : DishesAdapter.DishListItemClickListener{
            override fun onItemClicked(position: Int, dish: Dish) {
                listener.onDishItemClicked(dish)
            }

        }
        dishesAdapter.btnListener = object : DishesAdapter.FavoriteButtonListener{
            override fun onButtonClicked(position: Int, dish: Dish) {
                listener.favoriteBtnClicked(dish)
            }

        }

        create_dish_button.setOnClickListener{
            listener.onCreateDishButton()
        }
    }

    fun notifyDataChanged (){
        dishesAdapter.notifyDataSetChanged()
    }

    interface DishesListFragmentListener{
        fun onCreateDishButton()

        fun onDishItemClicked(dish: Dish)

        fun favoriteBtnClicked(dish: Dish)
    }
}