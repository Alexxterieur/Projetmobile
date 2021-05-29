package com.example.projetmobile.presentation.api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeItemAPI {
    @GET("item")
    fun getPokeItem(): Call<PokeItemResponse>
}