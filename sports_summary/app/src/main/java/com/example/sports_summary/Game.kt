package com.example.sports_summary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.sports_summary.adapter.SeasonInfoAdapter
import com.example.sports_summary.pojo.api.ApiService
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_season_one.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Game : AppCompatActivity() {

    var homeGoal=0
    var awayGoal = 0
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        tv_score.text = "SCORE $count"
        game()
    }

    fun game(){
        val a = (Math.random()*3).toInt()
        when(a){
            0 -> {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.football-data-api.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val service = retrofit.create(ApiService::class.java)
                CoroutineScope(Dispatchers.IO).launch {
                    val response = service.getSeasonOne()
                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful) {

                            val gson = GsonBuilder().setPrettyPrinting().create()
                            val prettyJson = gson.toJson(response.body())
                            Log.d("Pretty Printed JSON :", prettyJson)
                            val items = response.body()?.data
                            if (items != null) {
                                for( i in 0 until items.count()) {
                                    val homeName = items[i].homeName ?: "N/A"
                                    val awayName = items[i].awayName ?: "N/A"
                                    val season = items[i].season ?: "N/A"

                                    homeGoal = (items[i].homeGoalCount ?: "N/A") as Int
                                    awayGoal = (items[i].awayGoalCount ?: "N/A") as Int

                                    tv_season.text = season
                                    tv_home_name.text = homeName
                                    tv_away_name.text = awayName
                                }
                            }

                        } else {

                            Log.e("RETROFIT_ERROR", response.code().toString())

                        }
                    }
                }
            }

            1 -> {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.football-data-api.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val service = retrofit.create(ApiService::class.java)
                CoroutineScope(Dispatchers.IO).launch {
                    val response = service.getSesonTwo()
                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful) {

                            val gson = GsonBuilder().setPrettyPrinting().create()
                            val prettyJson = gson.toJson(response.body())
                            Log.d("Pretty Printed JSON :", prettyJson)
                            val items = response.body()?.data
                            if (items != null) {
                                for( i in 0 until items.count()) {
                                    val homeName = items[i].homeName ?: "N/A"
                                    val awayName = items[i].awayName ?: "N/A"
                                    val season = items[i].season ?: "N/A"


                                    homeGoal = (items[i].homeGoalCount ?: "N/A") as Int
                                    awayGoal = (items[i].awayGoalCount ?: "N/A") as Int


                                    tv_season.text = season
                                    tv_home_name.text = homeName
                                    tv_away_name.text = awayName
                                }
                            }

                        } else {

                            Log.e("RETROFIT_ERROR", response.code().toString())

                        }
                    }
                }

            }
            2 -> {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.football-data-api.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val service = retrofit.create(ApiService::class.java)
                CoroutineScope(Dispatchers.IO).launch {
                    val response = service.getSesonThree()
                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful) {

                            val gson = GsonBuilder().setPrettyPrinting().create()
                            val prettyJson = gson.toJson(response.body())
                            Log.d("Pretty Printed JSON :", prettyJson)
                            val items = response.body()?.data
                            if (items != null) {
                                for( i in 0 until items.count()) {
                                    val homeName = items[i].homeName ?: "N/A"
                                    val awayName = items[i].awayName ?: "N/A"
                                    val season = items[i].season ?: "N/A"

                                    homeGoal = (items[i].homeGoalCount ?: "N/A") as Int
                                    awayGoal = (items[i].awayGoalCount ?: "N/A") as Int


                                    tv_season.text = season
                                    tv_home_name.text = homeName
                                    tv_away_name.text = awayName
                                }
                            }

                        } else {

                            Log.e("RETROFIT_ERROR", response.code().toString())

                        }
                    }
                }
            }
        }
    }

    fun homeTeam(view: View) {
        if (homeGoal>awayGoal){
            count++
            tv_score.text = "SCORE $count"
            game()
        }else{
            game()
        }

    }
    fun awayTeam(view: View) {
        if (homeGoal<awayGoal){
            count++
            tv_score.text = "SCORE $count"
            game()
        }else{
            game()
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }



}