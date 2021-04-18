package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_dish_info.*

class DishInfoFragment:Fragment() {
    lateinit var dish: Dish
    lateinit var listener:BackClickListener
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dish_info,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTV.text = dish.name
        imageViewDt.setImageResource(dish.imageView)
        ratingTV.text = dish.rating.toString()
        descriptionTV.text = dish.description

        back_button.setOnClickListener{
            listener.backClicked()
        }
    }


    interface BackClickListener{
        fun backClicked()
    }
}