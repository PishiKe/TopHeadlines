package com.pishi.topheadlines.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pishi.topheadlines.R
import com.pishi.topheadlines.network.Article

class NewsAdapter (private val newsList : List<Article>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        return holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {

        return newsList.size
    }

    class NewsViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

        private val title: TextView = itemView.findViewById(R.id.tv_title)

        fun bind (news : Article){
            title.text = news.title
        }

    }
}