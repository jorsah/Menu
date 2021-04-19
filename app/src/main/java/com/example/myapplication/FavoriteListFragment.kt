package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_favorite_dishes.*

class FavoriteListFragment:Fragment() {
    private val favoriteAdapter = FavoriteAdapter(favoriteDishes)
    lateinit var listener: DishInfoFragment.BackClickListener
    lateinit var itemListener: DishesListFragment.DishesListFragmentListener
    lateinit var deleteBtnListener: FavoriteListFragmentListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_dishes,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favorite_recycler_view.layoutManager = LinearLayoutManager(context)
        favorite_recycler_view.adapter = favoriteAdapter
        favoriteAdapter.notifyDataSetChanged()

        back_button3.setOnClickListener {
            listener.backClicked()
        }
        favoriteAdapter.itemClickListener = object : DishesAdapter.DishListItemClickListener{
            override fun onItemClicked(position: Int, dish: Dish) {
                itemListener.onDishItemClicked(dish)
            }

        }
        favoriteAdapter.listener = object : FavoriteAdapter.DeleteBtnListener {
            override fun deleteBtnClicked(position: Int, dish: Dish) {
                deleteBtnListener.deleted(dish)
            }
        }
    }
    fun notifyDataChanged (){
        favoriteAdapter.notifyDataSetChanged()
    }
}
interface FavoriteListFragmentListener{
    fun deleted(dish: Dish)
}