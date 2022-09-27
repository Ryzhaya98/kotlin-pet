package com.example.shoppinglist_clean.domain

class EditShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun editShoppItem(shopItem: ShopItem){
        shopListRepository.editShoppItem(shopItem)
    }
}