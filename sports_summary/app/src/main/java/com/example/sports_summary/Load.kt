package com.example.sports_summary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class Load : AppCompatActivity() {
    lateinit var loader:ImageView
    lateinit var animationRotateCenter: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        loader = findViewById(R.id.iv_loader)
       animationRotateCenter  = AnimationUtils.loadAnimation(this, R.anim.anim);
        startTimer()

    }


    fun startTimer(){
        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                loader.startAnimation(animationRotateCenter);
            }

            override fun onFinish() {
                val intent = Start.newIntent(this@Load)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }
}