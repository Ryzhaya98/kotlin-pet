package com.example.shoppinglist_clean.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglist_clean.domain.*
import com.example.shoppinglist_clean.data.*
class ShopItemViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val addItem = AddObjectShopListUseCase(repository)
    private val editItem = EditShopItemUseCase(repository)
    private val getItem = GetShopItemUseCase(repository)

    fun getShopItem(shopItemId:Int){
        val item = getItem.getShopIten(shopItemId)
    }

    fun addShopItem(inputName:String?, inputCount: String?){
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldValied = validateInput(name, count)
        if (fieldValied) {
            val shopItem = ShopItem(name,count, true)
            addItem.addObject(shopItem)
        }
    }

    fun editShopItem(inputName:String?, inputCount: String?){

        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldValied = validateInput(name, count)
        if (fieldValied) {
            val shopItem = ShopItem(name,count, true)
            editItem.editShoppItem(shopItem)
        }
    }

    private fun parseName(inputName: String?):String{
        return inputName?.trim() ?:""
    }

    private fun parseCount(inputCount: String?):Int{
        return try {
            inputCount?.trim()?.toInt() ?:0
        }catch (e:java.lang.Exception){
            0
        }
    }

    private fun validateInput(name:String, count:Int):Boolean{
        var result = true
        //TODO
        if (name.isBlank()){
            result = false
        }

        if (count<=0){
            result = false
        }

        return result
    }

}