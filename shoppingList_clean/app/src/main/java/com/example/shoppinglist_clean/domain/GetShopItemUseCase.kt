package com.example.shoppinglist_clean.domain

class GetShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun getShopIten(shopItemId:Int):ShopItem{
       return shopListRepository.getShopIten(shopItemId)
    }
}