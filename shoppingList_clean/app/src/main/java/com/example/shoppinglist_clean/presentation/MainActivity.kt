package com.example.shoppinglist_clean.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist_clean.R
import com.example.shoppinglist_clean.domain.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var shopListAdapter: ShopListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRV()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            shopListAdapter.submitList(it)

        }

        button_add_shop_item.setOnClickListener {
            val intent = ShopItemActivity.newIntentAddItem(this)
            startActivity(intent)
        }

    }

    private fun setupRV() {
        shopListAdapter = ShopListAdapter()
        rv_shop_list.adapter = shopListAdapter
        rv_shop_list.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_EN,
            ShopListAdapter.MAX_POOL_SIZE)
        rv_shop_list.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_DIS,
            ShopListAdapter.MAX_POOL_SIZE)
        shopListAdapter.onShopItemLongClickListener = {
            viewModel.editShopItem(it)

        }
        shopListAdapter.onShopItemShortClick = {
            Log.d("setOnClickListener", "onShopItemShortClick")
            val intent = ShopItemActivity.newIntentEditItem(this, it.id)
            startActivity(intent)
        }
        val callBack = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = shopListAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deletedShopItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callBack)
        itemTouchHelper.attachToRecyclerView(rv_shop_list)

    }
}