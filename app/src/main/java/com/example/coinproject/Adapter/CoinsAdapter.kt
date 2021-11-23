package com.example.coinproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coinproject.R
import com.example.coinproject.model.Coins
import com.example.coinproject.model.CoinsItem

class CoinsAdapter(
    private val coinsList: List<CoinsItem>,
    context: Context
) : RecyclerView.Adapter<CoinsAdapter.CoinViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_coins, parent, false)

        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coinsItem: CoinsItem = coinsList[position]

        holder.tvCoinsName.text = coinsItem.name
//        Glide.with(context).load(post.getWebformatURL()).into(holder.imageViewPostContent)

    }

    override fun getItemCount(): Int {
        return coinsList.size
    }


    class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCoinsName: TextView = itemView.findViewById(R.id.tvCoinsName)
//        val imageViewCoinsPic: ImageView = itemView.findViewById(R.id.imageViewCoinsPic)
    }

}