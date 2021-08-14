package com.siddhesh.pricelinetest.bestseller

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.siddhesh.common.models.BookDetailsModel

class RowBestSellerListViewModel(bookDetailsModel: BookDetailsModel) : ViewModel() {
    var displayName = ObservableField("")
    var description = ObservableField("")
    var author = ObservableField("")
    var price = ObservableField("")

    init {
        displayName.set(bookDetailsModel.title)
        description.set(bookDetailsModel.description)
        author.set(bookDetailsModel.author)
        price.set(bookDetailsModel.price)
    }

}