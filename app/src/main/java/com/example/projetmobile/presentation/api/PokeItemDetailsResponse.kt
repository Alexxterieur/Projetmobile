package com.example.projetmobile.presentation.api

data class PokeItemDetailsResponse(
    val name:String,
    val attributes: List<PokeItemAttribute>,
    val effect_entries: List<PokeItemEffects>,
    val flavor_text_entries: List<PokeItemText>
)

data class PokeItemText(
    val language: LanguageUse,
    val text: String
)

data class PokeItemEffects(
    val effect: String,
    val language: LanguageUse
)

data class LanguageUse(
    val name:String,
    val url: String
)

data class PokeItemAttribute(
    val name: String,
    val url:String
)


