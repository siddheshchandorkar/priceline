package com.siddhesh.common.models

import com.google.gson.annotations.SerializedName
import com.siddhesh.common.utils.JsonKeys

data class BestSellerModel(

    @SerializedName(JsonKeys.KEY_BOOK_DETAILS)
    var bookDetails: ArrayList<BookDetailsModel>? = ArrayList()

)
