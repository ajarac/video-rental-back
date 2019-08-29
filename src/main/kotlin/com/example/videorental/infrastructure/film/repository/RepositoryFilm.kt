package com.example.videorental.infrastructure.film.repository

import com.example.videorental.domain.film.Film
import com.example.videorental.domain.shared.TypeId

interface RepositoryFilm {
    fun addFilm(film: Film)
    fun getAllFilms(): List<Film>
    fun getFilmByFilmId(filmId: TypeId): Film
}