package com.example.videorental.domain.film

import com.example.videorental.domain.shared.TypeId

interface RepositoryFilm {
    fun addFilm(film: Film)
    fun getAllFilms(): List<Film>
    fun getFilmByFilmId(filmId: TypeId): Film
}