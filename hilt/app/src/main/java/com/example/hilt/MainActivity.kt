package com.example.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import com.example.hilt.db.UserEntity
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // click btn save
        // val userEntity = UserEntity(name = edittext.text.toString())
        //viewModel.insertRecord(userEntity)
        //
        initVM()
    }

    private fun initVM (){
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecordObserver().observe(this,object :Observer<List<UserEntity>>{
            override fun onChanged(t: List<UserEntity>?) {
                // TODO: result отображаем
                t?.forEach {
                    // TODO: здесь можно использовтаь recyclerview 
                }
            }

        })
    }
}