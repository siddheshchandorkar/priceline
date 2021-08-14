package com.siddhesh.pricelinetest.bestseller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.siddhesh.network.RetrofitRepository
import com.siddhesh.pricelinetest.R
import com.siddhesh.pricelinetest.databinding.ActivityBestSellerBinding

class BestSellerActivity : AppCompatActivity() {
    private lateinit var bestSellerViewModel: BestSellerViewModel
    private lateinit var binding: ActivityBestSellerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_best_seller)
        binding.lifecycleOwner = this
        supportActionBar?.title= getString(R.string.best_seller_list)

        if (intent != null && intent.hasExtra(FROM_NAME)) {
            bestSellerViewModel = BestSellerViewModel(intent.getStringExtra(FROM_NAME)!!)
            binding.vm = bestSellerViewModel

            val linearLayoutManager = LinearLayoutManager(this)
            binding.rcvBestSeller.layoutManager = linearLayoutManager
            binding.rcvBestSeller.adapter = bestSellerViewModel.bestSellerListAdapter
            binding.rcvBestSeller.addOnScrollListener(bestSellerViewModel.onScrollListener(linearLayoutManager))
//
//
            RetrofitRepository.instance.bookDetailsListsLiveData.observe(this, {list->
                bestSellerViewModel.isProgressBarVisible.set(false)
                bestSellerViewModel.mLoadingMore = false
                if (list == null || list.isEmpty()) {
                    bestSellerViewModel.noMoreData = true
                }else {
                    list.forEach {bookDetailsModel->
                        bestSellerViewModel.bestSellerList.add(RowBestSellerListViewModel(bookDetailsModel))
                    }
                    bestSellerViewModel.bestSellerListAdapter.notifyDataSetChanged()
                }
//
//
//
            })
        }
    }

    companion object {
        const val FROM_NAME = "from_name"
    }
}