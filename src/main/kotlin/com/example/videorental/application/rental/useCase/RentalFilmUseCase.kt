package com.example.videorental.application.rental.useCase

import com.example.videorental.application.rental.events.RentalFilmEvent
import com.example.videorental.domain.film.Film
import com.example.videorental.domain.rental.Rental
import com.example.videorental.infrastructure.film.repository.RepositoryFilm
import com.example.videorental.infrastructure.rental.repository.RepositoryRental
import com.example.videorental.infrastructure.film.exception.FilmInUseException

class RentalFilmUseCase(private val repositoryRental: RepositoryRental, private val repositoryFilm: RepositoryFilm) {

    fun execute(rentalFilmEvent: RentalFilmEvent): Rental {
        val film: Film = repositoryFilm.getFilmByFilmId(rentalFilmEvent.filmId)
        return if (film.isUsed) {
            throw FilmInUseException()
        } else {
            film.rentalFilm()
            createRental(rentalFilmEvent)
        }
    }

    private fun createRental(rentalFilmEvent: RentalFilmEvent): Rental {
        val rental = Rental(filmId = rentalFilmEvent.filmId, customerId = rentalFilmEvent.customerId)
        repositoryRental.addRental(rental)
        return rental
    }
}