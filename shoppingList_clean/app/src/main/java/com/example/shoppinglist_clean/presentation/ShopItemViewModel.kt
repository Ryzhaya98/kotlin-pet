package com.example.shoppinglist_clean.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist_clean.domain.*
import com.example.shoppinglist_clean.data.*
class ShopItemViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val addItem = AddObjectShopListUseCase(repository)
    private val editItem = EditShopItemUseCase(repository)
    private val getItem = GetShopItemUseCase(repository)

   private val _errInputName = MutableLiveData<Boolean>()
    val errInputName:LiveData<Boolean>
    get() = _errInputName

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount:LiveData<Boolean>
    get() = _errorInputCount

    private val _shopItem = MutableLiveData<ShopItem>()
    val shopItem:LiveData<ShopItem>
            get() = _shopItem

    fun getShopItem(shopItemId:Int){
        val item = getItem.getShopIten(shopItemId)
        _shopItem.value = item
    }

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen :LiveData<Unit>
    get() = _shouldCloseScreen

    fun addShopItem(inputName:String?, inputCount: String?){
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldValied = validateInput(name, count)
        if (fieldValied) {
            val shopItem = ShopItem(name,count, true)
            addItem.addObject(shopItem)
            finishWork()
        }
    }

    fun editShopItem(inputName:String?, inputCount: String?){

        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldValied = validateInput(name, count)
        if (fieldValied) {
             _shopItem.value?.let {
                 val item = it.copy(name = name,count = count)
                 editItem.editShoppItem(item)
                 finishWork()
             }


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
        if (name.isBlank()){
            _errInputName.value = true
            result = false
        }

        if (count<=0){
            _errorInputCount.value = true
            result = false
        }

        return result
    }

     fun resetErrorInputName(){
        _errInputName.value = false
    }
    fun resetErrorInputCount(){
        _errorInputCount.value = false
    }
private fun finishWork(){
    _shouldCloseScreen.value = Unit
}
}