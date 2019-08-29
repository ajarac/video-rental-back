package com.example.videorental.infrastructure.rental.adapter

import com.example.videorental.infrastructure.rental.controller.dto.RentalFilmDTO
import com.example.videorental.infrastructure.rental.controller.dto.RentalResponseDTO
import com.example.videorental.infrastructure.rental.controller.dto.ReturnFilmDTO

interface RentalAdapter {
    fun getRentalById(rentalId: String): RentalResponseDTO
    fun rentalFilm(rentalFilmDTO: RentalFilmDTO): RentalResponseDTO
    fun returnFilm(returnFilmDTO: ReturnFilmDTO): RentalResponseDTO
}