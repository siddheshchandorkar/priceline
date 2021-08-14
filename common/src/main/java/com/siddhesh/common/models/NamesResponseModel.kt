package com.siddhesh.common.models

import com.google.gson.annotations.SerializedName
import com.siddhesh.common.utils.JsonKeys

data class NamesResponseModel(
    @SerializedName(JsonKeys.KEY_STATUS)
    var status: String? = "",
    @SerializedName(JsonKeys.KEY_NUM_RESULTS)
    var numResults: String? = "",
    @SerializedName(JsonKeys.KEY_RESULTS)
    var results: ArrayList<NamesModel> = ArrayList()
)
