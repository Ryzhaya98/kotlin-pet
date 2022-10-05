package com.example.journal_test_task.ui

import com.example.journal_test_task.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.journal_test_task.model.Article
import com.example.journal_test_task.network.APIService
import com.example.journal_test_task.ui.viewmodel.ArticleListViewModel
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.fragment_article_detail.*
import kotlinx.android.synthetic.main.fragment_article_detail.view.*
import kotlinx.android.synthetic.main.item_article.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Retrofit


class ArticleDetailFragment : Fragment() {
    private lateinit var viewModel: ArticleListViewModel
    var a = 0
    var list = ArrayList<String>()
    var txt = ""
    var str_img = ""
    var listArticle = ArrayList<Article>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article_detail, container, false)
        val b = arguments
        val s = b!!.getString("pos")
        a = s?.toInt()!!
        Log.d("TESTDFFDCVBGFC2", s.toString())
        viewModel = ViewModelProvider(this).get(ArticleListViewModel::class.java)
        txt = viewModel.getArticleDetail(list,a)
        listArticle = viewModel.getArticle()
        str_img = listArticle.get(a).imgString
        view.iv_article_detail.setImageResource(context?.resources!!.getIdentifier(str_img, "drawable", context?.packageName))
        view.tc_article_detail.text = txt

        view.iv_heart.setOnClickListener {
            rawJSON()
        }

        view.iv_arrow_back.setOnClickListener {

            val articleFragment: Fragment = ArticleFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment_container,
                articleFragment)
            transaction.addToBackStack(null)

            transaction.commit()

        }

        return view
    }


    companion object {
        fun newInstance() = ArticleDetailFragment()
    }

    fun rawJSON() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://dummy.restapiexample.com")
            .build()

        val service = retrofit.create(APIService::class.java)
        val jsonObject = JSONObject()
        jsonObject.put("name", "Test")
        jsonObject.put("salary", "Test")
        jsonObject.put("age", "Test")
        val jsonObjectString = jsonObject.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        CoroutineScope(Dispatchers.IO).launch {

            val response = service.createEmployee(requestBody)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(
                            response.body()
                                ?.string()
                        )
                    )
                    Toast.makeText(context, "POST SUCCESS", Toast.LENGTH_SHORT).show()
                    Log.d("Pretty Printed JSON :", prettyJson)

                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }
    }
}