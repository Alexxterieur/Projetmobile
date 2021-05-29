package com.example.projetmobile.presentation

import com.example.projetmobile.presentation.PokeItemApplication.Companion.context
import com.example.projetmobile.presentation.api.PokeItemAPI
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class Singleton {
    companion object{
        var cache:Cache = Cache(File(context?.cacheDir,"responses"),10*1024*1024)
        val okhttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()

        val pokeItemApi:PokeItemAPI = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient)
            .build()
            .create(PokeItemAPI::class.java)

    }
}
