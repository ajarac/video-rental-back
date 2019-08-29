package com.example.videorental.application.film.useCase

import com.example.videorental.application.film.events.CalculatePriceRentalFilmEvent
import com.example.videorental.domain.film.Film
import com.example.videorental.infrastructure.film.repository.RepositoryFilm

class CalculatePriceRentalFilmUseCase(private val repositoryFilm: RepositoryFilm) {

    fun execute(calculatePriceRentalFilmEvent: CalculatePriceRentalFilmEvent): Int {
        val film: Film = repositoryFilm.getFilmByFilmId(calculatePriceRentalFilmEvent.filmId)
        return film.calculatePrice(calculatePriceRentalFilmEvent.days)
    }
}