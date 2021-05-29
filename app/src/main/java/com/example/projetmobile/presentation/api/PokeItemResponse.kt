package com.example.projetmobile.presentation.api

import com.example.projetmobile.presentation.liste.PokeItem

data class PokeItemResponse(
    val count: Int,
    val next: String,
    val results: List<PokeItem>
)