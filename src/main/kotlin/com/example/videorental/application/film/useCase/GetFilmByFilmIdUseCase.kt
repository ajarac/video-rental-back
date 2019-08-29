package com.example.videorental.application.film.useCase

import com.example.videorental.domain.film.Film
import com.example.videorental.domain.shared.TypeId
import com.example.videorental.infrastructure.film.repository.RepositoryFilm

class GetFilmByFilmIdUseCase(private val repositoryFilm: RepositoryFilm) {

    fun execute(filmId: TypeId): Film {
        return repositoryFilm.getFilmByFilmId(filmId)
    }
}