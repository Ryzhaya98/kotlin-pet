package com.example.journal_test_task


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.journal_test_task.ui.ArticleFragment
import com.example.journal_test_task.ui.JournalFragment
import com.example.journal_test_task.ui.ProfileFragment
import com.example.journal_test_task.ui.adapter.OnItemClick
import kotlinx.android.synthetic.main.activity_main.*
import com.example.journal_test_task.ui.ArticleDetailFragment

class MainActivity : AppCompatActivity() ,OnItemClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(JournalFragment.newInstance())

        bottom_navigation.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.journal_fragment -> {

                    fragment = JournalFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.articles_fragment -> {

                    fragment = ArticleFragment()
                    loadFragment(fragment)
                    true

                }
                R.id.profile_fragment -> {

                    fragment = ProfileFragment()
                    loadFragment(fragment)
                    true

                }
                else -> false
            }

        }

        bottom_navigation.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.journal_fragment -> {
                    Toast.makeText(this, "Journal Item reselected", Toast.LENGTH_SHORT).show()
                }
                R.id.articles_fragment -> {
                    Toast.makeText(this, "articles Item reselected", Toast.LENGTH_SHORT).show()
                }
                R.id.profile_fragment -> {
                    Toast.makeText(this, "profile Item reselected", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onItemClick(pos: Int) {
        val bundle = Bundle()
        bundle.putString("pos", pos.toString())
        var fragment: Fragment
        fragment = ArticleDetailFragment()
        fragment.setArguments(bundle)
        loadFragment(fragment)

    }

}