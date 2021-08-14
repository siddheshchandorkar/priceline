package com.siddhesh.pricelinetest.bestsellername

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.siddhesh.pricelinetest.R
import com.siddhesh.pricelinetest.databinding.RowNameListBinding


class NameListAdapter(var vmListViewModel: List<RowNameListViewModel>) :
    RecyclerView.Adapter<NameListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RowNameListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_name_list, parent, false
        )
        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: RowNameListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RowNameListViewModel) {
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

    fun setData(items: List<RowNameListViewModel>) {
        vmListViewModel = items
        notifyDataSetChanged()

    }


}