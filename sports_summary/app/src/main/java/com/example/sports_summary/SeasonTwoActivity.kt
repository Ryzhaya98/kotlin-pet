package com.example.sports_summary

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sports_summary.adapter.SeasonInfoAdapter
import com.example.sports_summary.pojo.api.ApiService
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_season_one.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class SeasonTwoActivity : AppCompatActivity() {
    var itemsArray: ArrayList<Cell> = ArrayList()
    lateinit var adapter: SeasonInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_season_two)
        parseJSON()

    }



    private fun parseJSON() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.football-data-api.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val service = retrofit.create(ApiService::class.java)
        CoroutineScope(Dispatchers.IO).launch {


            val response = service.getSesonTwo()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    // Convert raw JSON to pretty JSON using GSON library
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(response.body())
                    Log.d("Pretty Printed JSON :", prettyJson)


                    val items = response.body()?.data
                    if (items != null) {
                        for( i in 0 until items.count()) {
                            // ID


                            // Employee Name
                            val homeName = items[i].homeName ?: "N/A"
                            val homeImage = items[i].homeImage ?: "N/A"
                            val awayImage = items[i].awayImage ?: "N/A"
                            val awayName = items[i].awayName ?: "N/A"
                            val season = items[i].season ?: "N/A"
                            val homeGoalCount = items[i].homeGoalCount ?: "N/A"
                            val awayGoalCount = items[i].awayGoalCount ?: "N/A"
                            val stadiumName = items[i].stadiumName ?: "N/A"
                            Log.d("Employee Name: ", homeName)



                            val model =
                                Cell(homeName,homeImage,awayImage,awayName,season,
                                    homeGoalCount as Int, awayGoalCount as Int,stadiumName)
                            itemsArray.add(model)

                            adapter = SeasonInfoAdapter(itemsArray)
                            adapter.notifyDataSetChanged()
                        }
                    }


                    rvSeasonnfoList.adapter = adapter


                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }
    }
    companion object {


        fun newIntent(context: Context): Intent {
            val intent = Intent(context, SeasonTwoActivity::class.java)
            return intent
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}