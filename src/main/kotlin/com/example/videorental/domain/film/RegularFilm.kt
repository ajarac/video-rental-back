package com.example.videorental.domain.film

data class RegularFilm(override val title: String) : Film(title) {

    override val typeFilm: TypeFilm = TypeFilm.REGULAR

    override val priceUnit: Int = 1

    override fun calculatePrice(days: Int): Int {
        return when (days) {
            in 1..3 -> priceUnit
            else -> priceUnit + (days - 3)
        }
    }
}