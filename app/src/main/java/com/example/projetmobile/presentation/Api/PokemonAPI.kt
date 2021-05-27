package com.example.projetmobile.presentation.Api


import retrofit2.Call
import retrofit2.http.GET;

public interface PokemonAPI {
    @GET("anime")
    fun getPokemon(): Call<List<Repo>>;
}