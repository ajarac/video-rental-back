package com.example.videorental.infrastructure.rental.controller.dto

import com.example.videorental.domain.rental.Rental
import java.time.LocalDate

data class RentalResponseDTO(
        val rentalId: String,
        val filmId: String,
        val customerId: String,
        val dateInit: LocalDate,
        val dateEnd: LocalDate?,
        val price: Int?
) {
    companion object {

        fun fromEntity(rental: Rental): RentalResponseDTO {
            return RentalResponseDTO(
                    rentalId = rental.rentalId.toString(),
                    filmId = rental.filmId.toString(),
                    customerId = rental.customerId.toString(),
                    dateInit = rental.dateInit,
                    dateEnd = rental.dateEnd,
                    price = rental.price
            )
        }
    }
}