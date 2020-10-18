package com.example.networkapplications

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.networkapplications.entity.BaseResponse
import com.example.networkapplications.entity.Fact
import com.example.networkapplicationkotlin.server.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FactsModel(val context: Context) {
    fun getFacts() =
        App.getApi()?.getFacts()
}