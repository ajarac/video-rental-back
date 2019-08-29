package com.example.videorental.infrastructure.film.adapter

import com.example.videorental.infrastructure.film.controller.dto.CalculatePriceRentalFilmDTO
import com.example.videorental.infrastructure.film.controller.dto.FilmResponseDTO
import com.example.videorental.infrastructure.film.controller.dto.CreateFilmDTO
import com.example.videorental.infrastructure.film.controller.dto.PriceRentalFilmResponseDTO

interface FilmAdapter {
    fun getAllFilms(): List<FilmResponseDTO>
    fun getFilmByFilmId(filmIdString: String): FilmResponseDTO
    fun addFilm(createFilmDTO: CreateFilmDTO): FilmResponseDTO
    fun getPriceRentalByFilmIdAndDays(calculatePriceRentalFilmDTO: CalculatePriceRentalFilmDTO): PriceRentalFilmResponseDTO
}