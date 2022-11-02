package com.example.shoppinglist_clean.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist_clean.R
import  com.example.shoppinglist_clean.presentation.ShopItemViewModel
import  com.example.shoppinglist_clean.domain.ShopItem
import kotlinx.android.synthetic.main.activity_shop_item2.*

class ShopItemActivity : AppCompatActivity() {

    private lateinit var viewModel: ShopItemViewModel
    private var screenMode = MODE_UNKNOW
    private var shopItemId = ShopItem.UNDEFINDE_ID
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item2)
        parseIntent()
        viewModel = ViewModelProvider(this)[ShopItemViewModel::class.java]
        addTextChangeListeners()
        launchRightMode()
        observeViewModel()

    }

        private fun observeViewModel() {
        viewModel.errorInputCount.observe(this) {
            val message = if (it) {
                getString(R.string.error_input_count)
            } else {
                null
            }
            til_count.error = message
        }
        viewModel.errInputName.observe(this) {
            val message = if (it) {
                getString(R.string.error_input_name)
            } else {
                null
            }
            til_name.error = message
        }
        viewModel.shouldCloseScreen.observe(this) {
            finish()
        }
    }

    private fun launchRightMode() {
        when (screenMode) {
            MODE_EDIT -> launchEditMode()
            MODE_ADD -> launchAddMode()
        }
    }


        private fun addTextChangeListeners() {
        et_name.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputName()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        et_count.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputCount()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
    private fun launchEditMode(){
        viewModel.getShopItem(shopItemId)
        viewModel.shopItem.observe(this){
            et_name.setText(it.name)
            et_count.setText(it.count.toString())
            save_button.setOnClickListener {
                viewModel.editShopItem(et_name.text?.toString(),et_count.text?.toString())
            }

        }
    }
    private fun launchAddMode(){
        save_button.setOnClickListener {
            viewModel.addShopItem(et_name.text?.toString(),et_count.text?.toString())
        }
    }

    private fun parseIntent(){
        if (!intent.hasExtra(EXTRA_SCREEN_MODE)){
            throw RuntimeException("Param is absent")
        }
        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
        if (mode!= MODE_EDIT && mode!= MODE_ADD){
            throw RuntimeException("Param $mode unknow")
        }

        screenMode = mode
        if (screenMode== MODE_EDIT && !intent.hasExtra(EXTRA_SHOP_ITEM_ID)){
            throw RuntimeException("Param shop item id absent")
        }

        if (screenMode== MODE_EDIT){
            shopItemId= intent.getIntExtra(EXTRA_SHOP_ITEM_ID,ShopItem.UNDEFINDE_ID)
        }

    }



    companion object {
        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val EXTRA_SHOP_ITEM_ID = "extra_shop_item_id"
        private const val MODE_EDIT = "mode_edit"
        private const val MODE_ADD = "mode_add"
        private const val MODE_UNKNOW = ""
        fun newIntentAddItem(context:Context):Intent{
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_ADD)
            return intent
        }

        fun newIntentEditItem(context:Context, itemId:Int):Intent{
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE,MODE_EDIT )
            intent.putExtra(EXTRA_SHOP_ITEM_ID,itemId )
            return intent

        }
    }
}