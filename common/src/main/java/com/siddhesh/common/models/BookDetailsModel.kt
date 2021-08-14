package com.siddhesh.common.models

import com.google.gson.annotations.SerializedName
import com.siddhesh.common.utils.JsonKeys

data class BookDetailsModel(
    @SerializedName(JsonKeys.KEY_TITLE)
    var title: String? = "",
    @SerializedName(JsonKeys.KEY_DESCRIPTION)
    var description: String? = "",
    @SerializedName(JsonKeys.KEY_AUTHOR)
    var author: String? = "",
    @SerializedName(JsonKeys.KEY_PRICE)
    var price: String? = ""

)
