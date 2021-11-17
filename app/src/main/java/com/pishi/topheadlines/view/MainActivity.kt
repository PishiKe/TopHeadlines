package com.pishi.topheadlines.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pishi.topheadlines.R
import com.pishi.topheadlines.databinding.ActivityMainBinding
import com.pishi.topheadlines.network.NewsApiInterface
import com.pishi.topheadlines.network.ServiceBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val request =ServiceBuilder.buildService(NewsApiInterface::class.java)

        val call = request.getTopHeadlines()
    }
}