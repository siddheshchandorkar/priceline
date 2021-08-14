package com.siddhesh.common.models

data class BestSeller (var groupName: String):ListItemType()  {
    override fun getType(): Int {
        return TYPE_GROUP
    }
}