package com.itsm.apis.models

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class Api1Model {

    suspend fun translate(text: String, source:String, target:String): String{
        var translat = ""
        var retrofit = Retrofit.Builder()
            .baseUrl("https://text-translator2.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var translate = retrofit.create(Api1Resp::class.java)
        var translation = translate.translate(text, source, target)
        val resp = translation.awaitResponse()
        if(resp.isSuccessful)
            translat = resp.body()!!.data.translatedText
        /*translation.enqueue(object : Callback<Translation>{
            override fun onResponse(call: Call<Translation>, response: Response<Translation>) {
                Log.e("API1_FALLOSA: ", response.toString())
                Log.e("API1_FALLOSA: ", response.body()?.data.toString())
                if(response.body()?.data!!.translatedText != null){
                    translat = response.body()?.data!!.translatedText
                    Log.e("API1_FALLO: ", translat)
                }
            }

            override fun onFailure(call: Call<Translation>, t: Throwable) {
                Log.e("API1_FALLO: ", t.toString())
            }

        })*/

        return translat
    }

}