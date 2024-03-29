package com.example.videorental.application.rental.useCase

import com.example.videorental.application.rental.events.ReturnFilmEvent
import com.example.videorental.domain.customer.Customer
import com.example.videorental.domain.film.Film
import com.example.videorental.domain.rental.Rental
import com.example.videorental.domain.customer.RepositoryCustomer
import com.example.videorental.domain.film.RepositoryFilm
import com.example.videorental.domain.rental.RepositoryRental

class ReturnFilmUseCase(
        private val repositoryRental: RepositoryRental,
        private val repositoryFilm: RepositoryFilm,
        private val repositoryCustomer: RepositoryCustomer
) {

    fun execute(returnFilmEvent: ReturnFilmEvent): Rental {
        val rental: Rental = repositoryRental.getRentalByRentalId(returnFilmEvent.rentalId)
        val film: Film = repositoryFilm.getFilmByFilmId(rental.filmId)
        val customer: Customer = repositoryCustomer.getCustomerByCustomerId(rental.customerId)

        rental.filmReturn()
        rental.setPrice(film)
        film.returnFilm()
        customer.getBonusPoints(film.typeFilm)

        repositoryRental.updateRental(rental)
        repositoryFilm.updateFilm(film)
        repositoryCustomer.updateCustomer(customer)

        return rental
    }
}