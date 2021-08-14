package com.siddhesh.pricelinetest.bestsellername

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.siddhesh.common.models.BestSeller
import com.siddhesh.common.models.BookDetailsModel
import com.siddhesh.common.models.ListItemType
import com.siddhesh.common.models.NamesModel
import com.siddhesh.network.RetrofitRepository
import com.siddhesh.pricelinetest.R
import com.siddhesh.pricelinetest.bestseller.BestSellerActivity
import com.siddhesh.pricelinetest.databinding.ActivityBestSellerNameBinding

class BestSellerNameActivity : AppCompatActivity(),NameCallback {
    private lateinit var bestSellerNameViewModel: BestSellerNameViewModel
    private lateinit var binding: ActivityBestSellerNameBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_best_seller_name)
        bestSellerNameViewModel = BestSellerNameViewModel()
        binding.vm = bestSellerNameViewModel
        binding.lifecycleOwner = this
        binding.rcvName.layoutManager = LinearLayoutManager(this)
        binding.rcvName.adapter = bestSellerNameViewModel.nameListAdapter

        supportActionBar?.title= getString(R.string.name_list)

        RetrofitRepository.instance.namesListsLiveData.observe(this, {list->

            bestSellerNameViewModel.isProgressBarVisible.set(false)
            if(list!=null){
                val map = HashMap<String,ArrayList< ListItemType>>()
                list.forEach { namesModel->
                    if(!map.containsKey(namesModel.updated)){
                        val nameAl= ArrayList< ListItemType>()
                        nameAl.add(namesModel)
                        map[namesModel.updated!!] =nameAl
                    }else{
                        val nameAl= map[namesModel.updated!!]
                        nameAl!!.add(namesModel)
                        map[namesModel.updated!!] =nameAl
                    }
                }
                for (type in map.keys) {
                    val nameAl=map[type]!!
                    bestSellerNameViewModel.nameList.add(RowNameListViewModel(BestSeller(type+" ("+nameAl.size+")"),this))
                    for (pos in 0 until nameAl.size) {
                        ( nameAl[pos] as NamesModel).position=pos+1
                        bestSellerNameViewModel.nameList.add(RowNameListViewModel(( nameAl[pos] as NamesModel),this))
                    }
                }

                bestSellerNameViewModel.nameListAdapter.notifyDataSetChanged()
            }



        })

    }

    override fun onNameClick(namesModel: NamesModel) {
        val intent= Intent(this, BestSellerActivity::class.java)
        intent.putExtra(BestSellerActivity.FROM_NAME, namesModel.listNameEncoded)
        startActivity(intent)


    }
}