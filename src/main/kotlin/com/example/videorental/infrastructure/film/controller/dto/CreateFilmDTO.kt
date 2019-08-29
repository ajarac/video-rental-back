package com.example.videorental.infrastructure.film.controller.dto

import com.example.videorental.domain.film.TypeFilm

data class CreateFilmDTO(val title: String, val typeFilm: TypeFilm)