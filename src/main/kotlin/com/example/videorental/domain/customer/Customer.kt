package com.example.videorental.domain.customer

import com.example.videorental.domain.film.TypeFilm
import com.example.videorental.domain.shared.TypeId

data class Customer(val username: String) {

    val customerId: TypeId = TypeId(null)

    var points: Int = 0

    fun getBonusPoints(typeFilm: TypeFilm) {
        when(typeFilm) {
            TypeFilm.NEW -> points += 2
            else -> points++
        }
    }

}