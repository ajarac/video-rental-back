package com.example.videorental.infrastructure.film.controller.dto

import com.example.videorental.domain.film.Film

data class FilmResponseDTO(val filmId: String, val title: String, val typeFilm: String, val isUsed: Boolean) {

    companion object {
        fun fromEntity(film: Film): FilmResponseDTO {
            return FilmResponseDTO(filmId = film.filmId.toString(), title = film.title, typeFilm = film.typeFilm.toString(), isUsed = film.isUsed)
        }
    }
}