package com.example.videorental.infrastructure.rental.controller

import com.example.videorental.infrastructure.rental.adapter.RentalRestAdapter
import com.example.videorental.infrastructure.rental.controller.dto.RentalFilmDTO
import com.example.videorental.infrastructure.rental.controller.dto.RentalResponseDTO
import com.example.videorental.infrastructure.rental.controller.dto.ReturnFilmDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rental")
class RentalController(@Autowired private val rentalRestAdapter: RentalRestAdapter) {

    @GetMapping("/{id}")
    fun getRentalByRentalId(@PathVariable id: String ): RentalResponseDTO {
        return rentalRestAdapter.getRentalById(id)
    }

    @PostMapping("")
    fun rentalFilm(@RequestBody rentalFilm: RentalFilmDTO): RentalResponseDTO {
        return rentalRestAdapter.rentalFilm(rentalFilm)
    }

    @PostMapping("/return")
    fun returnFilm(@RequestBody returnFilmDTO: ReturnFilmDTO): RentalResponseDTO {
        return rentalRestAdapter.returnFilm(returnFilmDTO)
    }
}