package com.siddhesh.pricelinetest.bestsellername

import android.net.Uri
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.siddhesh.common.models.BestSeller
import com.siddhesh.common.models.ListItemType
import com.siddhesh.common.models.NamesModel

class RowNameListViewModel(val listViewModel: ListItemType,val nameCallback: NameCallback) : ViewModel() {
    var displayName = ObservableField("")
    var groupName = ObservableField("")

    init {
        if(listViewModel is BestSeller){
            groupName.set(listViewModel.groupName)
        }else if(listViewModel is NamesModel){
            displayName.set("${listViewModel.position}. "+listViewModel.displayName+" (${listViewModel.newestPublishedDate})")

        }
    }

    fun onClickName(view: View){
        if(listViewModel is NamesModel){
            nameCallback.onNameClick(listViewModel)
        }

    }

}