package com.example.networkapplicationkotlin.server

import com.example.networkapplications.entity.BaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    companion object {
        val BASE_URL: String = "https://cat-fact.herokuapp.com/"
    }
    @GET("facts")
     fun getFacts():Call<BaseResponse>?
}

