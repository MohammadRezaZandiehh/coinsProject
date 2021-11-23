package com.example.coinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coinproject.Adapter.CoinsAdapter
import com.example.coinproject.PixabyModel.PixabyPost
import com.example.coinproject.databinding.ActivityMainBinding
import com.example.coinproject.model.Coins
import com.example.coinproject.model.CoinsItem
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.coinLiveData.observe(this, Observer {
            it.enqueue(object : Callback<List<CoinsItem>> {
                override fun onResponse(call: Call<List<CoinsItem>>, response: Response<List<CoinsItem>>) {
                    Log.d("MainActivity", "onCreate: ")
                    val coinId = response.body()!!


                    val coinsAdapter = CoinsAdapter(coinId, this@MainActivity)
                    binding.rvMain.adapter = coinsAdapter
                    binding.rvMain.layoutManager = LinearLayoutManager(this@MainActivity)

                }

                override fun onFailure(call: Call<List<CoinsItem>>, t: Throwable) {
                    Log.d("MainActivity", "onCreate: " + t.message)

                }
            })
        })
    }
}