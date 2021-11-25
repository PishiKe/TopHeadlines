package com.pishi.topheadlines.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.pishi.topheadlines.databinding.ActivityMainBinding
import com.pishi.topheadlines.network.*
import com.pishi.topheadlines.util.Constants
import com.pishi.topheadlines.view.adapter.NewsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val request =ServiceBuilder.buildService(NewsApiInterface::class.java)

        val call = request.getTopHeadlines(Constants.API_KEY_VALUE, Constants.COUNTRY_VALUE)

        call.enqueue(object: Callback<TopHeadlines>{
            override fun onResponse(call: Call<TopHeadlines>, response: Response<TopHeadlines>) {
                if (response.isSuccessful){
                    binding.rvNewsList.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = NewsAdapter(response.body()!!.articles, this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<TopHeadlines>, t: Throwable) {
                Toast.makeText(this@MainActivity,"${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}