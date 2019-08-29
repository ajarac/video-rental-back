package com.example.videorental.application.film.useCase

import com.example.videorental.domain.film.Film
import com.example.videorental.infrastructure.film.repository.RepositoryFilm

class GetAllFilmsUseCase(private val repositoryFilm: RepositoryFilm) {

    fun execute(): List<Film> {
        return repositoryFilm.getAllFilms()
    }
}