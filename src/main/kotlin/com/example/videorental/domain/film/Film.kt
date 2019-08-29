package com.example.videorental.domain.film

import com.example.videorental.domain.shared.TypeId

abstract class Film(open val title: String) {

    val filmId: TypeId = TypeId(null)

    var isUsed: Boolean = false

    abstract val typeFilm: TypeFilm

    abstract fun calculatePrice(days: Int): Int

    protected abstract val priceUnit: Int

    fun rentalFilm() {
        isUsed = true
    }

    fun returnFilm() {
        isUsed = false
    }


}