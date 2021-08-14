package com.siddhesh.network

import com.siddhesh.common.models.BestSellerResponseModel
import com.siddhesh.common.models.NamesResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitService {

    @GET("lists/names.json")
    fun getNames(@Query("api-key") apiKey: String): Call<NamesResponseModel>
    @GET("lists.json")
    fun getBestSeller(@Query("api-key") apiKey: String,@Query("list") list: String,@Query("offset") offset: Int): Call<BestSellerResponseModel>
}