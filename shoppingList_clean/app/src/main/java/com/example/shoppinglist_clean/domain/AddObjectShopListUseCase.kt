package com.example.shoppinglist_clean.domain

class AddObjectShopListUseCase (private val shopListRepository: ShopListRepository) {

    fun addObject(shopItem: ShopItem){
        shopListRepository.addObject(shopItem)
    }
}