package com.example.videorental.application.rental.useCase

import com.example.videorental.application.rental.events.GetRentalByRentalIdEvent
import com.example.videorental.domain.rental.Rental
import com.example.videorental.infrastructure.rental.repository.RepositoryRental

class GetRentalByRentalIdUseCase(private val repositoryRental: RepositoryRental) {

    fun execute(getRentalByRentalIdEvent: GetRentalByRentalIdEvent): Rental {
        return repositoryRental.getRentalByRentalId(getRentalByRentalIdEvent.rentalId)
    }
}