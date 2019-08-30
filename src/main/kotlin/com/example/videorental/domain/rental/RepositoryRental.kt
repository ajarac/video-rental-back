package com.example.videorental.domain.rental

import com.example.videorental.domain.shared.TypeId

interface RepositoryRental {
    fun addRental(rental: Rental)
    fun getRentalByRentalId(rentalId: TypeId): Rental
}