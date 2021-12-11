package com.dhandyjoe.stockku.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dhandyjoe.stockku.databinding.ItemListTransactionBinding
import com.dhandyjoe.stockku.model.Item
import com.dhandyjoe.stockku.model.Order

class TransactionAdapter(private val data: ArrayList<Item>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class MyViewHolder(val binding: ItemListTransactionBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemListTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = data[position]
        val totalItem = Order()

        if (holder is MyViewHolder) {
            totalItem.id = model.id
            holder.binding.tvNameItem.text = model.name
            holder.binding.tvSizeItem.text = model.size
            holder.binding.tvPriceItem.text = model.price
            holder.binding.tvIndicatorItem.text = totalItem.totalItem.toString()

            holder.binding.ivMinus.setOnClickListener {
                if (totalItem.totalItem > 0) {
                    totalItem.totalItem--
                    holder.binding.tvIndicatorItem.text = totalItem.totalItem.toString()
                }
            }

            holder.binding.ivPlus.setOnClickListener {
                totalItem.totalItem++
                holder.binding.tvIndicatorItem.text = totalItem.totalItem.toString()
            }
        }
    }

    override fun getItemCount(): Int = data.size
}