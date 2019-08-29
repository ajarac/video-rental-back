package com.example.videorental.domain.film

data class OldFilm(override val title: String): Film(title) {

    override val typeFilm: TypeFilm = TypeFilm.OLD

    override val priceUnit: Int = 1

    override fun calculatePrice(days: Int): Int {
        return when (days) {
            in 1..5 -> priceUnit
            else -> priceUnit + (days - 5)
        }
    }
}