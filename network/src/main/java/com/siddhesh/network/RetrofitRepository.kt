package com.siddhesh.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.siddhesh.common.models.BestSellerResponseModel
import com.siddhesh.common.models.BookDetailsModel
import com.siddhesh.common.models.NamesModel
import com.siddhesh.common.models.NamesResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RetrofitRepository {
     private val retrofitService = RetrofitFactory.makeRetrofitService()

    var namesListsLiveData = MutableLiveData<ArrayList<NamesModel>>()
    var bookDetailsListsLiveData = MutableLiveData<ArrayList<BookDetailsModel>>()


    private object HOLDER {
        val INSTANCE = RetrofitRepository()
    }

    companion object {
        val instance: RetrofitRepository by lazy { HOLDER.INSTANCE }
    }

    suspend fun getNames() {
        retrofitService.getNames("HDwynjK19EeWgjuImdrPCqNtEs08IVYW").enqueue(object : Callback<NamesResponseModel> {

            override fun onResponse(
                call: Call<NamesResponseModel>,
                response: Response<NamesResponseModel>
            ) {
                try {
                    if (response.body() != null) {

                        if (response.body()!!.results != null) {
                            namesListsLiveData.value = response.body()!!.results
                        } else {
                            namesListsLiveData.value = null
                        }

                    }else{
                        namesListsLiveData.value = null
                    }
                } catch (t: Throwable) {
                    namesListsLiveData.value =null
                    t.printStackTrace()
                }
            }

            override fun onFailure(call: Call<NamesResponseModel>, t: Throwable) {
                namesListsLiveData.value = null
                t.printStackTrace()

            }

        })

    }

    suspend fun getBookDetails(listName: String, offset:Int) {

        retrofitService.getBestSeller("HDwynjK19EeWgjuImdrPCqNtEs08IVYW", listName, offset).enqueue(object : Callback<BestSellerResponseModel> {

            override fun onResponse(
                call: Call<BestSellerResponseModel>,
                response: Response<BestSellerResponseModel>
            ) {
                try {

                    if (response.body() != null) {
                        if (response.body()!!.results != null) {
                            val bookList=ArrayList<BookDetailsModel>()
                            response.body()!!.results!!.forEach {
                                bookList.addAll(it.bookDetails!!)
                            }
                            if(bookList.isNotEmpty()){
                                bookDetailsListsLiveData.value=(bookList)

                            }else{
                                bookDetailsListsLiveData.value = null
                            }

                        } else {
                            bookDetailsListsLiveData.value = null
                        }

                    }else{
                        bookDetailsListsLiveData.value = null
                    }
                } catch (t: Throwable) {
                    bookDetailsListsLiveData.value = null
                    t.printStackTrace()
                }
            }

            override fun onFailure(call: Call<BestSellerResponseModel>, t: Throwable) {
                bookDetailsListsLiveData.value = null
                t.printStackTrace()
            }

        })

    }


}





