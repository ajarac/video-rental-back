package com.example.videorental.domain.film

data class NewFilm(override val title: String): Film(title) {

    override val typeFilm: TypeFilm = TypeFilm.NEW

    override val priceUnit: Int = 3

    override fun calculatePrice(days: Int): Int {
        return days * priceUnit
    }
}