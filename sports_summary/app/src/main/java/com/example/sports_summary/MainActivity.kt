package com.example.sports_summary

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sports_summary.pojo.api.ApiFactory
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
//import com.example.sports_summary.request.Reques
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
   // val reques = Reques()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_info.movementMethod = ScrollingMovementMethod()
        setSupportActionBar(toolbar)





    }
    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemview = item.itemId
        when(itemview)
        {
            R.id.season_one ->
            {
                val intent = SeasonOneActivity.newIntent(this@MainActivity)
                startActivity(intent)
                finish()
            }
            R.id.season_two ->{
                val intent = SeasonTwoActivity.newIntent(this@MainActivity)
                startActivity(intent)
                finish()
            }


            R.id.season_three -> {
                val intent = SeasonThreeActivity.newIntent(this@MainActivity)
                startActivity(intent)
                finish()
            }

            R.id.game ->{
                val intent = Intent(this, Game::class.java)
                startActivity(intent)
                finish()
            }
        }
        return false
    }

}