package com.example.videorental.infrastructure.film.controller

import com.example.videorental.infrastructure.film.adapter.FilmRestAdapter
import com.example.videorental.infrastructure.film.controller.dto.CalculatePriceRentalFilmDTO
import com.example.videorental.infrastructure.film.controller.dto.FilmResponseDTO
import com.example.videorental.infrastructure.film.controller.dto.CreateFilmDTO
import com.example.videorental.infrastructure.film.controller.dto.PriceRentalFilmResponseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/films")
class FilmController(@Autowired val filmRestAdapter: FilmRestAdapter) {

    @GetMapping()
    fun getAllFilms(): List<FilmResponseDTO> {
        return filmRestAdapter.getAllFilms()
    }


    @GetMapping("/{id}")
    fun getFilmByFilmId(@PathVariable id: String): FilmResponseDTO {
        return filmRestAdapter.getFilmByFilmId(id)
    }

    @GetMapping("/{id}/calculate")
    fun getPriceRentalByFilmIdAndDays(@PathVariable id: String, @RequestParam days: Int): PriceRentalFilmResponseDTO {
        val calculatePriceRentalFilmDTO = CalculatePriceRentalFilmDTO(filmId = id, days = days)
        return filmRestAdapter.getPriceRentalByFilmIdAndDays(calculatePriceRentalFilmDTO)
    }

    @PostMapping()
    fun createFilm(@RequestBody filmDTO: CreateFilmDTO): ResponseEntity<FilmResponseDTO> {
        return ResponseEntity(filmRestAdapter.addFilm(filmDTO), HttpStatus.CREATED)
    }

}