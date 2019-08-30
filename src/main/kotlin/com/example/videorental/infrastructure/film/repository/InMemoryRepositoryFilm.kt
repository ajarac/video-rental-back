package com.example.videorental.infrastructure.film.repository

import com.example.videorental.domain.film.Film
import com.example.videorental.domain.film.RepositoryFilm
import com.example.videorental.domain.shared.TypeId
import com.example.videorental.infrastructure.shared.exception.ItemNotFoundException
import org.springframework.stereotype.Repository

@Repository
class InMemoryRepositoryFilm : RepositoryFilm {
    private val listFilm: HashSet<Film> = HashSet<Film>()

    override fun addFilm(film: Film) {
        listFilm.add(film)
    }

    override fun getAllFilms(): List<Film> {
        return listFilm.toList()
    }

    override fun getFilmByFilmId(filmId: TypeId): Film {
        return listFilm.find { it.filmId.equals(filmId) } ?: throw ItemNotFoundException("Film not found with filmId: $filmId")
    }

    override fun updateFilm(film: Film) {
        listFilm.removeIf { it.filmId.equals(film.filmId) }
        listFilm.add(film)
    }
}