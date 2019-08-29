package com.example.videorental.infrastructure.rental.repository

import com.example.videorental.domain.rental.Rental
import com.example.videorental.domain.shared.TypeId

interface RepositoryRental {
    fun addRental(rental: Rental)
    fun getRentalByRentalId(rentalId: TypeId): Rental
}