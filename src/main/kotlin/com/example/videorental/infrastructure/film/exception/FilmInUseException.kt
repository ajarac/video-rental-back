package com.example.videorental.infrastructure.film.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.BAD_REQUEST)
class FilmInUseException(): RuntimeException() {
    override val message: String = "Film In Use"
}