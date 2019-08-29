package com.example.videorental.application.film.events

import com.example.videorental.domain.shared.TypeId

class CalculatePriceRentalFilmEvent(val filmId: TypeId, val days: Int)