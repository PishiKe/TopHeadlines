package com.pishi.topheadlines.view.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pishi.topheadlines.databinding.NewsItemBinding
import com.pishi.topheadlines.network.Article

class NewsAdapter (private val newsList : List<Article>, val activity: Activity) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val binding : NewsItemBinding = NewsItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        val news = newsList[position]

        holder.tvTitle.text = news.title

        Glide.with(activity)
            .load(news.urlToImage)
            .centerCrop()
            .into(holder.ivImage)

        holder.itemView.setOnClickListener {
            val intent = Intent()
        }

    }

    override fun getItemCount(): Int {

        return newsList.size
    }

    class NewsViewHolder (view : NewsItemBinding) : RecyclerView.ViewHolder(view.root){

         val tvTitle: TextView = view.tvTitle
         val ivImage: ImageView = view.ivNewsImage

    }
}