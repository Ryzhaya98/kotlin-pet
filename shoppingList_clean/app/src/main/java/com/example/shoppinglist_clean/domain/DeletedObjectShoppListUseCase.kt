package com.example.shoppinglist_clean.domain

class DeletedObjectShoppListUseCase (private val shopListRepository: ShopListRepository){

    fun deleteShopItem(shopItem: ShopItem){
        shopListRepository.deleteShopItem(shopItem)
    }
}