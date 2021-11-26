package com.pishi.topheadlines.view.adapter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pishi.topheadlines.databinding.NewsItemBinding
import com.pishi.topheadlines.network.Article
import com.pishi.topheadlines.view.fragments.SelectedNewsFragment

class NewsAdapter (private val newsList : List<Article>, val fragment : Fragment) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val binding : NewsItemBinding = NewsItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        val news = newsList[position]

        holder.tvTitle.text = news.title

        Glide.with(fragment)
            .load(news.urlToImage)
            .centerCrop()
            .into(holder.ivImage)

        holder.itemView.setOnClickListener {

            val openUrl = Intent(android.content.Intent.ACTION_VIEW)

            openUrl.data = Uri.parse(news.url)

            fragment.startActivity(openUrl)
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