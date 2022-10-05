package com.example.journal_test_task.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.journal_test_task.MainActivity
import com.example.journal_test_task.R
import com.example.journal_test_task.model.Article
import kotlinx.android.synthetic.main.item_article.view.*
import com.example.journal_test_task.ui.ArticleDetailFragment

class ArticleAdapter(val articleList:ArrayList<Article>):RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    var listener: OnItemClick? = null

    fun YourAdapter(activity: Activity?) {
        listener = activity as MainActivity?
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ArticleAdapter.ViewHolder(v)
    }



    override fun onBindViewHolder(holder: ArticleAdapter.ViewHolder, position: Int) {
        holder.bindItems(articleList[position])

        holder.itemView.setOnClickListener {

            listener?.onItemClick(position)


        }


    }
    override fun getItemCount(): Int {
        return articleList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(article: Article) {
            itemView.apply {
                tv_title.text = article.title
                tv_date.text = article.date
                bottom_navigation.text = "Подробнее"
                imageView1.setImageResource(context.resources.getIdentifier(article.imgString, "drawable", context.packageName))
            }

        }
    }
}



