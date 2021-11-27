package com.example.taxiapp

import com.example.taxiapp.net.ApiRet
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Obj
{
    fun getRetrofit() : ApiRet{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mskko2021.mad.hakta.pro/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val getApi = retrofit.create(ApiRet::class.java)
        return getApi
    }
}