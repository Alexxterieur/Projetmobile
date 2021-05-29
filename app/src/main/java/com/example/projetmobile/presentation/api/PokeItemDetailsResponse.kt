package com.example.projetmobile.presentation.api

data class PokeItemDetailsResponse(
    val name:String,
    val attributes: List<PokeItemAttribute>,
    val effect_entries: List<PokeItemEffects>,
    val flavor_text_entries: List<PokeItemText>,
    val sprites:String
)

data class PokeItemText(
    val language_text: LanguageUse,
    val text: String
)

data class PokeItemEffects(
    val effect: String,
    val language_eff: LanguageUse
)

data class LanguageUse(
    val name_lang:String,
    val url: String
)

data class PokeItemAttribute(
    val name_attribute: String,
    val url:String
)


