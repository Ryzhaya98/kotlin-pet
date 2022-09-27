package com.example.shoppinglist_clean.data
import com.example.shoppinglist_clean.domain.ShopItem
import com.example.shoppinglist_clean.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var auto_id = 0
    override fun addObject(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINDE_ID) {
            shopItem.id = auto_id++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShoppItem(shopItem: ShopItem) {
        val oldElement = getShopIten(shopItem.id)
        shopList.remove(oldElement)
        addObject(shopItem)
    }

    override fun getShopIten(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }?:throw RuntimeException("не найдено")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}