package com.example.videorental.application.film.events

import com.example.videorental.domain.film.TypeFilm

class CreateFilmEvent(val title: String, val typeFilm: TypeFilm)