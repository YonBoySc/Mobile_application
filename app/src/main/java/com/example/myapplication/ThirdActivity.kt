package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var adapter: FoodItemAdapter
    private lateinit var b: ActivityThirdBinding
    private val foodItemsList: MutableList<FoodItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(b.root)

        populateList()

        setUpAdapter()
    }
    private fun setUpAdapter() {

        adapter = FoodItemAdapter(this,foodItemsList)

        b.foodItemsRV.adapter = adapter
        b.foodItemsRV.layoutManager = LinearLayoutManager(this)
    }

    private fun populateList() {
        for (i in 1..15){
            val name = "Food Item $i"
            val price = (100 * i).toFloat()

            val foodItem = FoodItem(name = name, price = price)

            foodItemsList.add(foodItem)
        }
    }
}