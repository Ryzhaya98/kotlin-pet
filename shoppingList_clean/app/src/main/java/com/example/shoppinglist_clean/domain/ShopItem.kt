package com.example.shoppinglist_clean.domain

data class ShopItem (
    val name:String,
    val count: Int,
    val enabled:Boolean,
    var id:Int = UNDEFINDE_ID
        )
{
    companion object{
        const val UNDEFINDE_ID = -1
    }
}
