package com.example.videorental.infrastructure.rental.repository

import com.example.videorental.domain.rental.Rental
import com.example.videorental.domain.rental.RepositoryRental
import com.example.videorental.domain.shared.TypeId
import com.example.videorental.infrastructure.shared.exception.ItemNotFoundException
import org.springframework.stereotype.Repository

@Repository
class InMemoryRepositoryRental: RepositoryRental {

    private val listRental: HashSet<Rental> = HashSet<Rental>()

    override fun addRental(rental: Rental) {
        listRental.add(rental)
    }

    override fun getRentalByRentalId(rentalId: TypeId): Rental {
        return listRental.find { it.rentalId.equals(rentalId) } ?: throw ItemNotFoundException("Rental not found with rental id: $rentalId")
    }
}