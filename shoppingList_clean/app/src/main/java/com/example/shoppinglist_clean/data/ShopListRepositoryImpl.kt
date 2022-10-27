package com.example.shoppinglist_clean.data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist_clean.domain.ShopItem
import com.example.shoppinglist_clean.domain.ShopListRepository
import java.lang.RuntimeException
import kotlin.random.Random

object ShopListRepositoryImpl : ShopListRepository {
    private val shopListLiveData = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({o1,o2 ->o1.id.compareTo(o2.id)})
    private var auto_id = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, Random.nextBoolean())
            addObject(item)
        }
    }
    override fun addObject(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINDE_ID) {
            shopItem.id = auto_id++
        }
        shopList.add(shopItem)
        updateList()

    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShoppItem(shopItem: ShopItem) {
        val oldElement = getShopIten(shopItem.id)
        shopList.remove(oldElement)
        addObject(shopItem)
    }

    override fun getShopIten(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }?:throw RuntimeException("не найдено")
    }

    override fun getShopList(): LiveData< List<ShopItem>> {
        return shopListLiveData
    }
    private fun updateList(){
        shopListLiveData.value = shopList.toList()
    }
}