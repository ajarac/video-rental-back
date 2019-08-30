package com.example.videorental.application.film.useCase

import com.example.videorental.application.film.events.CreateFilmEvent
import com.example.videorental.domain.film.FactoryFilm
import com.example.videorental.domain.film.Film
import com.example.videorental.domain.film.RepositoryFilm

class CreateFilmUseCase(private val repositoryFilm: RepositoryFilm) {

    fun execute(createFilmEvent: CreateFilmEvent): Film {
        val film: Film = FactoryFilm.createFilm(title = createFilmEvent.title, typeFilm = createFilmEvent.typeFilm)
        repositoryFilm.addFilm(film)
        return film
    }
}