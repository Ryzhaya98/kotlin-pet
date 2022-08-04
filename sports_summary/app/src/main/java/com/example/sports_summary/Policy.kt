package com.example.sports_summary

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent


class Policy : AppCompatActivity() {
    var url = "https://google.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_policy)

        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
    }

        fun newIntent2(context: Context): Intent {
            val intent = Intent(context, Policy::class.java)
            return intent
        }


    override fun onBackPressed() {
        val intent = Intent(this, Start::class.java)
        startActivity(intent)
        finish()
    }

}