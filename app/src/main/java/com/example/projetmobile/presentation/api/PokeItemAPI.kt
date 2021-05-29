package com.example.projetmobile.presentation.api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeItemAPI {
    @GET("item")
    fun getPokeItem(): Call<PokeItemResponse>

    @GET("item/{id}")
    fun getPokeItemDetails(@Path("id") id:String): Call<PokeItemDetailsResponse>
}