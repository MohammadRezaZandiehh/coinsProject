package com.example.coinproject.adapter

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

class MainAdapter(
    private val coinList: List<Coins>,
    private val context: Context
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_main, parent, false)

        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val coins: Coins = coinList[position]

        holder.textViewShowNameCoins.text = coins.name
        holder.textViewSymbol.text = coins.symbol
        holder.textViewId.text = coins.id
        holder.textViewCurrentPrice.text = coins.currentprice

        Glide.with(context)
            .load(coins.image)
            .circleCrop()
            .into(holder.imageViewShowCoinPic);

    }

    override fun getItemCount(): Int {
        return coinList.size
    }


    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewShowNameCoins: TextView = itemView.findViewById(R.id.textViewShowNameCoins)
        val textViewSymbol: TextView = itemView.findViewById(R.id.textViewSymbol)
        val textViewId: TextView = itemView.findViewById(R.id.textViewId)
        val textViewCurrentPrice: TextView = itemView.findViewById(R.id.textViewCurrentPrice)

        val imageViewShowCoinPic :ImageView = itemView.findViewById(R.id.imageViewShowCoinPic)
    }
}