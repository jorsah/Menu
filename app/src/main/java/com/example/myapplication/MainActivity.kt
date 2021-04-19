 package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

 class MainActivity : AppCompatActivity(),
        DishesListFragment.DishesListFragmentListener,
        DishCreateFragment.CreateDishFragmentListener,
        DishInfoFragment.BackClickListener, FavoriteListFragmentListener {
    private val dishesListFragment = DishesListFragment()
    private val dishCreateFragment = DishCreateFragment()
    private val favoriteListFragment = FavoriteListFragment()
    private val dishInfoFragment = DishInfoFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dishesListFragment.listener = this
        dishInfoFragment.listener = this
        dishCreateFragment.listener = this
        favoriteListFragment.listener =this
        favoriteListFragment.itemListener = this
        favoriteListFragment.deleteBtnListener = this
        supportFragmentManager.beginTransaction().add(R.id.container,dishesListFragment).commit()
    }

    override fun onCreateDishButton() {
        dishCreateFragment.createDishFragmentListener = this
        supportFragmentManager.beginTransaction().replace(R.id.container,dishCreateFragment).commit()
    }

    override fun onDishItemClicked(dish: Dish) {
        dishInfoFragment.dish = dish
        supportFragmentManager.beginTransaction().replace(R.id.container,dishInfoFragment).commit()
    }

    override fun favoriteBtnClicked(dish: Dish) {
        if(!favoriteDishes.contains(dish)){
            favoriteDishes.add(dish)
        }
    }

    override fun favoriteClicked() {
        supportFragmentManager.beginTransaction().replace(R.id.container,favoriteListFragment).commit()
    }


    override fun onDishCreated(dish: Dish) {
        dishes.add(dish)
        dishesListFragment.notifyDataChanged()
        supportFragmentManager.beginTransaction().replace(R.id.container,dishesListFragment).commit()
    }
    override fun backClicked() {
        supportFragmentManager.beginTransaction().replace(R.id.container,dishesListFragment).commit()
    }

     override fun deleted(dish: Dish) {
         favoriteDishes.remove(dish)
         favoriteListFragment.notifyDataChanged()
     }


 }