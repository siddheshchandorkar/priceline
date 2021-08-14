package com.siddhesh.pricelinetest.bestseller

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siddhesh.network.RetrofitRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BestSellerViewModel(private val listName: String) : ViewModel() {

    var isProgressBarVisible= ObservableBoolean(true)
    var bestSellerList= ArrayList<RowBestSellerListViewModel>()
    var bestSellerListAdapter = BestSellerListAdapter(bestSellerList)
    var offSet=0
    var mLoadingMore = false
     var noMoreData = false

    init {
        bestSellerListAdapter.notifyDataSetChanged()


        callGetBookDetailsApi()

    }

    private fun callGetBookDetailsApi() {
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            RetrofitRepository.instance.getBookDetails(this@BestSellerViewModel.listName, offSet)
        }

    }


    fun onScrollListener(linearLayoutManager: LinearLayoutManager): RecyclerView.OnScrollListener {
        return object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount = linearLayoutManager.itemCount
                val visibleItemCount = linearLayoutManager.childCount
                val firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount) {
                    if (!mLoadingMore && !noMoreData) {
                        mLoadingMore = true
                        offSet+= REQUEST_ITEM_COUNT
                        isProgressBarVisible.set(true)
                        callGetBookDetailsApi()

                    }
                }
            }
        }
    }

    companion object {
        const val REQUEST_ITEM_COUNT = 20
    }
}