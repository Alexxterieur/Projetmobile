package com.example.projetmobile.presentation

import com.example.projetmobile.presentation.api.PokeItemAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Singleton {
    companion object{
        val pokeItemApi:PokeItemAPI = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeItemAPI::class.java)
    }
}
