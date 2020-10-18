package com.example.networkapplications

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.networkapplications.entity.BaseResponse
import com.example.networkapplications.entity.Fact
import com.example.networkapplicationkotlin.server.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FactsPresenter(context: Context,fragment: MainFragment){
    val call: Call<BaseResponse>? = FactsModel(context).getFacts();
    init{
        call?.enqueue(object : Callback<BaseResponse> {
            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                fragment.FailedFacts()
            }

            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                fragment.SuccessFacts(response)
            }
        })
    }
}