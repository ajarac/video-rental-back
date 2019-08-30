package com.example.videorental.infrastructure.film.adapter

import com.example.videorental.application.film.events.CalculatePriceRentalFilmEvent
import com.example.videorental.application.film.events.CreateFilmEvent
import com.example.videorental.application.film.useCase.CalculatePriceRentalFilmUseCase
import com.example.videorental.application.film.useCase.CreateFilmUseCase
import com.example.videorental.application.film.useCase.GetAllFilmsUseCase
import com.example.videorental.application.film.useCase.GetFilmByFilmIdUseCase
import com.example.videorental.domain.film.Film
import com.example.videorental.domain.shared.TypeId
import com.example.videorental.infrastructure.film.controller.dto.CalculatePriceRentalFilmDTO
import com.example.videorental.infrastructure.film.controller.dto.FilmResponseDTO
import com.example.videorental.infrastructure.film.controller.dto.CreateFilmDTO
import com.example.videorental.infrastructure.film.controller.dto.PriceRentalFilmResponseDTO
import com.example.videorental.domain.film.RepositoryFilm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FilmRestAdapter(@Autowired private val repositoryFilm: RepositoryFilm) : FilmAdapter {

    private val getAllFilmsUseCase: GetAllFilmsUseCase = GetAllFilmsUseCase(repositoryFilm)
    private val getFilmByFilmIdUseCase: GetFilmByFilmIdUseCase = GetFilmByFilmIdUseCase(repositoryFilm)
    private val createFilmUseCase: CreateFilmUseCase = CreateFilmUseCase(repositoryFilm)
    private val calculatePriceRentalFilmUseCase = CalculatePriceRentalFilmUseCase(repositoryFilm)

    override fun getAllFilms(): List<FilmResponseDTO> {
        val listFilm: List<Film> = getAllFilmsUseCase.execute()
        return listFilm.map { FilmResponseDTO.fromEntity(it) }
    }

    override fun getFilmByFilmId(filmIdString: String): FilmResponseDTO {
        val filmId = TypeId(filmIdString)
        val foundFilm = getFilmByFilmIdUseCase.execute(filmId)
        return FilmResponseDTO.fromEntity(foundFilm)
    }

    override fun addFilm(createFilmDTO: CreateFilmDTO): FilmResponseDTO {
        val createFilmEvent = CreateFilmEvent(title = createFilmDTO.title, typeFilm = createFilmDTO.typeFilm)
        val film: Film = createFilmUseCase.execute(createFilmEvent)
        return FilmResponseDTO.fromEntity(film)
    }

    override fun getPriceRentalByFilmIdAndDays(calculatePriceRentalFilmDTO: CalculatePriceRentalFilmDTO): PriceRentalFilmResponseDTO {
        val filmId = TypeId(calculatePriceRentalFilmDTO.filmId)
        val calculatePriceRentalFilmEvent = CalculatePriceRentalFilmEvent(filmId = filmId, days = calculatePriceRentalFilmDTO.days)
        val price: Int = calculatePriceRentalFilmUseCase.execute(calculatePriceRentalFilmEvent)
        return PriceRentalFilmResponseDTO(filmId = filmId.toString(), price = price, days = calculatePriceRentalFilmDTO.days)
    }

}