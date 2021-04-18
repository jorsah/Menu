 package com.example.myapplication

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),
        DishesListFragment.DishesListFragmentListener,
        DishCreateFragment.CreateDishFragmentListener,
        DishInfoFragment.BackClickListener
{
    private val dishesListFragment = DishesListFragment()
    lateinit var dishCreateFragment: DishCreateFragment
    var dishInfoFragment = DishInfoFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dishesListFragment.listener = this
        dishInfoFragment.listener = this
        supportFragmentManager.beginTransaction().add(R.id.container,dishesListFragment).commit()
    }

    override fun onCreateDishButton() {
        val dishCreateFragment = DishCreateFragment()
        dishCreateFragment.createDishFragmentListener = this
        supportFragmentManager.beginTransaction().replace(R.id.container,dishCreateFragment).commit()
    }

    override fun onDishItemClicked(dish: Dish) {
        dishInfoFragment.dish = dish
        supportFragmentManager.beginTransaction().replace(R.id.container,dishInfoFragment).commit()
    }

    override fun favoriteBtnClicked(dish: Dish) {
        favoriteDishes.add(dish)
    }


    override fun onDishCreated(dish: Dish) {
        dishes.add(dish)
        dishesListFragment.notifyDataChanged()
        supportFragmentManager.beginTransaction().replace(R.id.container,dishesListFragment).commit()
    }
    override fun backClicked() {
        supportFragmentManager.beginTransaction().replace(R.id.container,dishesListFragment).commit()
    }
}