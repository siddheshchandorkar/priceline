package com.siddhesh.pricelinetest.bestsellername

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.siddhesh.network.RetrofitRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BestSellerNameViewModel : ViewModel() {

    var isProgressBarVisible= ObservableBoolean(false)
    var nameList= ArrayList<RowNameListViewModel>()
    var nameListAdapter : NameListAdapter = NameListAdapter(nameList)
    init {
        nameListAdapter.notifyDataSetChanged()
        isProgressBarVisible.set(true)

        CoroutineScope(Dispatchers.IO).launch {
            RetrofitRepository.instance.getNames()
        }
    }
}