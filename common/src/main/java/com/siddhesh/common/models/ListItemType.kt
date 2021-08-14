package com.siddhesh.common.models

 abstract class ListItemType {

     abstract fun getType(): Int

     companion object {
         const val TYPE_GROUP = 0
         const val TYPE_NAME = 1
     }
 }