package com.example.coroutines_hilt_flow.ui.listing

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import com.example.coroutines_hilt_flow.R
import com.example.coroutines_hilt_flow.model.Movie
import com.example.coroutines_hilt_flow.model.Result
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.loading

@AndroidEntryPoint
class ListingActivity :AppCompatActivity() {
    private val list = ArrayList<Movie>()
    private val viewModel by viewModels<ListingViewModel>()
    private lateinit var moviesAdapter: MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        subscribeUi()
    }

    fun init() {
        val layoutManager = LinearLayoutManager(this)
        rvMovies.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(
            rvMovies.context, layoutManager.orientation
        )
        rvMovies.addItemDecoration(dividerItemDecoration)
        moviesAdapter = MoviesAdapter(this, list)
        rvMovies.adapter = moviesAdapter
    }

    private fun subscribeUi() {
        viewModel.movieList.observe(this, Observer { result ->

            when (result.status) {
                Result.Status.SUCCESS -> {
                    result.data?.results?.let { list ->
                        moviesAdapter.updateData(list)
                    }
                    loading.visibility = View.GONE
                }

                Result.Status.ERROR -> {
                    result.message?.let {
                        showError(it)
                    }
                    loading.visibility = View.GONE
                }

                Result.Status.LOADING -> {
                    loading.visibility = View.VISIBLE
                }
            }

        })
    }

    private fun showError(msg: String) {
        Snackbar.make(vParent, msg, Snackbar.LENGTH_INDEFINITE).setAction("DISMISS") {
        }.show()
    }
}