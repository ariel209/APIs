package com.itsm.apis.models

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api1Resp {
    @FormUrlEncoded
    @Headers(
        "content-type: application/x-www-form-urlencoded",
        "X-RapidAPI-Key: 0c0111d441msh6f62ef6cafd624cp16d039jsn7d4bfc5ef9dd",
        "X-RapidAPI-Host: text-translator2.p.rapidapi.com"
    )
    @POST("translate")
    abstract fun translate(@Field("text") text: String, @Field("source_language") source:String, @Field("target_language") target:String): Call<Translation>;

}