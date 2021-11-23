package com.example.coinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coinproject.Apiservice.ApiService
import com.example.coinproject.adapter.MainAdapter
import com.example.coinproject.databinding.ActivityMainBinding
import com.example.coinproject.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder().baseUrl("http://expertdevelopers.ir/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(apiService::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.coinsLiveData.observe(this, Observer {
            Log.d("MainActivity: " , "onCreate: "  )

            val mainAdapter: MainAdapter? =
                it?.let { responseName ->
                    MainAdapter(
                        responseName,
                        this@MainActivity
                    )
                }

            binding.rvMain.adapter = mainAdapter
            binding.rvMain.layoutManager = LinearLayoutManager(this@MainActivity)

        })
    }
}