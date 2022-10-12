package com.example.shoppinglist_clean.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun addObject(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)

    fun editShoppItem(shopItem: ShopItem)

    fun getShopIten(shopItemId:Int):ShopItem

    fun getShopList(): LiveData< List<ShopItem>>
}