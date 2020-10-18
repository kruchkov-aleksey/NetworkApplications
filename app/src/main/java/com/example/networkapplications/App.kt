package com.example.networkapplications

import android.app.Application
import com.example.networkapplicationkotlin.server.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {
    companion object {
        private var api: Api? = null
        fun getApi(): Api?  {
            return api
        }
    }
    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(Api::class.java)
    }
}