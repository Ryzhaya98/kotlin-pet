package com.example.shoppinglist_clean.domain

import androidx.lifecycle.LiveData

class GetShoppListUseCase (private val shopListRepository: ShopListRepository){
    fun getShopList(): LiveData<List<ShopItem>>{
         return shopListRepository.getShopList()
    }
}