package com.itsm.apis.models

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api2Resp {

    @Headers(
        "X-RapidAPI-Key: 0c0111d441msh6f62ef6cafd624cp16d039jsn7d4bfc5ef9dd",
        "X-RapidAPI-Host: free-nba.p.rapidapi.com"
    )
    @GET("teams?page=0")
    abstract fun getAll():Call<General>
}