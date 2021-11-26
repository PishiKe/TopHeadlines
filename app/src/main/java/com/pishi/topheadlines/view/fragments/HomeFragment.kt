package com.pishi.topheadlines.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.pishi.topheadlines.R
import com.pishi.topheadlines.databinding.FragmentHomeBinding
import com.pishi.topheadlines.network.NewsApiInterface
import com.pishi.topheadlines.network.ServiceBuilder
import com.pishi.topheadlines.network.TopHeadlines
import com.pishi.topheadlines.util.Constants
import com.pishi.topheadlines.view.adapter.NewsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)


        val request = ServiceBuilder.buildService(NewsApiInterface::class.java)

        val call = request.getTopHeadlines(Constants.API_KEY_VALUE, Constants.COUNTRY_VALUE)

        call.enqueue(object: Callback<TopHeadlines> {
            override fun onResponse(call: Call<TopHeadlines>, response: Response<TopHeadlines>) {
                if (response.isSuccessful){
                    binding.rvNewsList.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = NewsAdapter(response.body()!!.articles, this@HomeFragment)
                    }
                }
            }

            override fun onFailure(call: Call<TopHeadlines>, t: Throwable) {
                Toast.makeText(requireContext(),"${t.message}", Toast.LENGTH_SHORT).show()
            }

        })

        return binding.root
    }
}