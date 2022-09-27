package com.example.shoppinglist_clean.domain

class GetShoppListUseCase (private val shopListRepository: ShopListRepository){
    fun getShopList(): List<ShopItem>{
         return shopListRepository.getShopList()
    }
}