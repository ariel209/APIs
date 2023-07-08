package com.itsm.apis.models

import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class Api2Model {

    suspend fun getAll(): ArrayList<Team>{
        var list = ArrayList<Team>()
        var retrofit = Retrofit.Builder()
            .baseUrl("https://free-nba.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var nba = retrofit.create(Api2Resp::class.java)
        var resp = nba.getAll().awaitResponse()
        if(resp.isSuccessful)
            list = resp.body()!!.data
        return list
    }



}