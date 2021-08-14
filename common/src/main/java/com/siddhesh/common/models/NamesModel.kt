package com.siddhesh.common.models

import com.google.gson.annotations.SerializedName
import com.siddhesh.common.utils.JsonKeys

data class NamesModel (

    @SerializedName(JsonKeys.KEY_DISPLAY_NAME)
    var displayName: String? = "",
    @SerializedName(JsonKeys.KEY_LIST_NAME_ENCODED)
    var listNameEncoded: String? = "",
    @SerializedName(JsonKeys.KEY_NEW_PUBLISH_DATE)
    var newestPublishedDate: String? = "",
    @SerializedName(JsonKeys.KEY_UPDATED)
    var updated: String? = "",
    var position: Int? = 0



): ListItemType(){
    override fun getType(): Int {
        return TYPE_NAME
    }


}
