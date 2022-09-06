package com.example.news_app_mvvm.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.news_app_mvvm.R
import com.example.news_app_mvvm.ui.NewsActivity
import com.example.news_app_mvvm.ui.NewsViewModel

class ArticleNewsFragment : Fragment(R.layout.fragment_article){
    lateinit var viewModel: NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}