package com.example.videorental.infrastructure.rental.adapter

import com.example.videorental.application.rental.events.GetRentalByRentalIdEvent
import com.example.videorental.application.rental.events.RentalFilmEvent
import com.example.videorental.application.rental.events.ReturnFilmEvent
import com.example.videorental.application.rental.useCase.GetRentalByRentalIdUseCase
import com.example.videorental.application.rental.useCase.RentalFilmUseCase
import com.example.videorental.application.rental.useCase.ReturnFilmUseCase
import com.example.videorental.domain.rental.Rental
import com.example.videorental.domain.shared.TypeId
import com.example.videorental.domain.customer.RepositoryCustomer
import com.example.videorental.domain.film.RepositoryFilm
import com.example.videorental.infrastructure.rental.controller.dto.RentalFilmDTO
import com.example.videorental.infrastructure.rental.controller.dto.RentalResponseDTO
import com.example.videorental.infrastructure.rental.controller.dto.ReturnFilmDTO
import com.example.videorental.domain.rental.RepositoryRental
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RentalRestAdapter(
        @Autowired private val repositoryRental: RepositoryRental,
        @Autowired private val repositoryFilm: RepositoryFilm,
        @Autowired private val repositoryCustomer: RepositoryCustomer
) : RentalAdapter {

    private val rentalFilmUseCase = RentalFilmUseCase(repositoryRental, repositoryFilm)
    private val returnFilmUseCase = ReturnFilmUseCase(repositoryRental, repositoryFilm, repositoryCustomer)
    private val getRentalByRentalIdUseCase = GetRentalByRentalIdUseCase(repositoryRental)

    override fun getRentalById(rentalId: String): RentalResponseDTO {
        val getRentalByRentalIdEvent = GetRentalByRentalIdEvent(TypeId(rentalId))
        val rental: Rental = getRentalByRentalIdUseCase.execute(getRentalByRentalIdEvent)
        return RentalResponseDTO.fromEntity(rental)
    }

    override fun rentalFilm(rentalFilmDTO: RentalFilmDTO): RentalResponseDTO {
        val rentalFilmEvent = RentalFilmEvent(filmId = TypeId(rentalFilmDTO.filmId), customerId = TypeId(rentalFilmDTO.customerId))
        val rental: Rental = rentalFilmUseCase.execute(rentalFilmEvent)
        return RentalResponseDTO.fromEntity(rental)
    }

    override fun returnFilm(returnFilmDTO: ReturnFilmDTO): RentalResponseDTO {
        val returnFilmEvent = ReturnFilmEvent(TypeId(returnFilmDTO.rentalId))
        val rental: Rental = returnFilmUseCase.execute(returnFilmEvent)
        return RentalResponseDTO.fromEntity(rental)
    }
}