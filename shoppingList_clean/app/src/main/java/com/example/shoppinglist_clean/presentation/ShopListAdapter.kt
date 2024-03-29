package com.example.shoppinglist_clean.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shoppinglist_clean.R
import com.example.shoppinglist_clean.domain.ShopItem

class ShopListAdapter :
    androidx.recyclerview.widget.ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemShortClick: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {

        val layout = when (viewType) {
            VIEW_TYPE_DIS -> R.layout.item_shop_disabled
            VIEW_TYPE_EN -> R.layout.item_shop_enabled
            else -> throw RuntimeException("UNKNOW VIEWTYPE")
        }
        val view =
            LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
        holder.itemView.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }

        holder.itemView.setOnClickListener {
            onShopItemShortClick?.invoke(shopItem)

        }

    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            VIEW_TYPE_EN
        } else {
            VIEW_TYPE_DIS
        }

    }

    companion object {
        const val VIEW_TYPE_EN = 0
        const val VIEW_TYPE_DIS = 1
        const val MAX_POOL_SIZE = 15
    }


}