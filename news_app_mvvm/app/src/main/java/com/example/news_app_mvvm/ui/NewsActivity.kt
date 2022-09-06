package com.example.news_app_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.news_app_mvvm.R
import com.example.news_app_mvvm.db.ArticleDatabase
import kotlinx.android.synthetic.main.activity_news.*
import com.example.news_app_mvvm.repository.NewsRepository
import com.example.news_app_mvvm.models.Article
class NewsActivity : AppCompatActivity() {
    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val repository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)
       // bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())

    }
}