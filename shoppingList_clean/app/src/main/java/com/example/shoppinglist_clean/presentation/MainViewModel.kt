package com.example.shoppinglist_clean.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist_clean.domain.*
import com.example.shoppinglist_clean.data.*
class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val getShoppListUseCase = GetShoppListUseCase(repository)
    private val deletedObjectShoppListUseCase = DeletedObjectShoppListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShoppListUseCase.getShopList()


    fun deletedShopItem( shopItem: ShopItem){
        deletedObjectShoppListUseCase.deleteShopItem(shopItem)

    }

    fun editShopItem(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShoppItem(newItem)

    }
}