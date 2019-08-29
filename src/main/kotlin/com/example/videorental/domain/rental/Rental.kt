package com.example.videorental.domain.rental

import com.example.videorental.domain.film.Film
import com.example.videorental.domain.shared.TypeId
import com.example.videorental.infrastructure.film.exception.InvalidFilmException
import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class Rental(val filmId: TypeId, val customerId: TypeId) {

    val rentalId: TypeId = TypeId(null)
    val dateInit: LocalDate = LocalDate.now()
    var dateEnd: LocalDate? = null
    var price: Int? = null

    fun filmReturn() {
        dateEnd = LocalDate.now()
    }

    fun setPrice(film: Film) {
        if (filmId.equals(film.filmId)) {
            val days: Int = ChronoUnit.DAYS.between(dateInit, dateEnd).toInt()
            price = film.calculatePrice(days)
        } else {
            throw InvalidFilmException()
        }
    }
}