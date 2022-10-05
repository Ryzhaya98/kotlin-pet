package com.example.journal_test_task.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.journal_test_task.R
import com.example.journal_test_task.model.Article
import com.example.journal_test_task.ui.adapter.ArticleAdapter
import com.example.journal_test_task.ui.viewmodel.ArticleListViewModel
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_article.*
import kotlinx.android.synthetic.main.fragment_article.view.*

class ArticleFragment : Fragment() {
    private lateinit var viewModel: ArticleListViewModel

    var list2 = ArrayList<Article>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article, container, false)
        viewModel = ViewModelProvider(this).get(ArticleListViewModel::class.java)
       list2 = viewModel.getArticle()
        view.recycler_view.layoutManager = LinearLayoutManager(activity)
        val ad = ArticleAdapter(list2)
        view.recycler_view.adapter = ad
        ad.YourAdapter(activity)
        return view
    }



    companion object {
        fun newInstance() = ArticleFragment()
    }

}