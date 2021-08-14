package com.siddhesh.pricelinetest.bestseller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.siddhesh.pricelinetest.R
import com.siddhesh.pricelinetest.databinding.RowBestSellerListBinding
import com.siddhesh.pricelinetest.databinding.RowNameListBinding


class BestSellerListAdapter(var vmListViewModel: List<RowBestSellerListViewModel>) :
    RecyclerView.Adapter<BestSellerListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RowBestSellerListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_best_seller_list, parent, false
        )
        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: RowBestSellerListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RowBestSellerListViewModel) {
            binding.vm = item
            binding.executePendingBindings()
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(vmListViewModel[position])

    }

    override fun getItemCount(): Int {
        return vmListViewModel.size
    }

    fun setData(items: List<RowBestSellerListViewModel>) {
        vmListViewModel = items
        notifyDataSetChanged()

    }


}