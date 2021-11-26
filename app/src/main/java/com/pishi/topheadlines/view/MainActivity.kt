package com.pishi.topheadlines.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pishi.topheadlines.R
import com.pishi.topheadlines.databinding.ActivityMainBinding
import com.pishi.topheadlines.network.*
import com.pishi.topheadlines.util.Constants
import com.pishi.topheadlines.view.adapter.NewsAdapter
import com.pishi.topheadlines.view.fragments.HomeFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                    add<HomeFragment>(R.id.home_fragment_container)
            }
        }
    }
}