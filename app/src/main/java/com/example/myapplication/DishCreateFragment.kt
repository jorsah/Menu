package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_create_dish.*

class DishCreateFragment:Fragment() {
    lateinit var createDishFragmentListener: CreateDishFragmentListener
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_dish,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        saveBtn.setOnClickListener {
            if(nameET.text.isNotEmpty() && ratingET.text.isNotEmpty()&&descriptionET.text.isNotEmpty()){
                val dish = Dish(nameET.text.toString(),ratingET.text.toString().toDouble(),R.drawable.dish_icon,descriptionET.text.toString())
                createDishFragmentListener.onDishCreated(dish)
            }
        }
    }
    interface CreateDishFragmentListener{
        fun onDishCreated(dish:Dish)
    }

}