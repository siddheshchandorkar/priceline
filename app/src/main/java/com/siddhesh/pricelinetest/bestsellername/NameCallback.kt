package com.siddhesh.pricelinetest.bestsellername

import com.siddhesh.common.models.NamesModel

interface NameCallback {

    fun onNameClick(namesModel: NamesModel)
}