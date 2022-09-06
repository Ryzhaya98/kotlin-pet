package com.example.news_app_mvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_app_mvvm.R
import com.example.news_app_mvvm.ui.NewsViewModel
import com.example.news_app_mvvm.ui.NewsActivity
import com.example.news_app_mvvm.adapters.NewsAdapter
import com.example.news_app_mvvm.util.Resource
import com.example.news_app_mvvm.models.NeswResponse
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news){
lateinit var viewModel:NewsViewModel
lateinit var newsAdapter: NewsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel


        viewModel.breakongNews.observe(viewLifecycleOwner, Observer { response->
            when(response){
                is Resource.Success->{
                    hiderProgressBar()
                    response.data?.let {neswResponse ->
                    newsAdapter.differ.submitList(neswResponse.articles)
                    }
                }
                is Resource.Error->{
                    hiderProgressBar()
                    response.mess?.let {mess ->
                       Log.e("BreakongERROR", mess)
                    }
                }

                is Resource.Loading->{
                   showProgressBar()
                }
            }
        })

        setuoRecyclerView()
    }

    private fun hiderProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }
    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }
    private fun setuoRecyclerView(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            rvBreakingNews.adapter =adapter
        }
    }
}