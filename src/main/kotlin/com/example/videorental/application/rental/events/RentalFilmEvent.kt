package com.example.videorental.application.rental.events

import com.example.videorental.domain.shared.TypeId

class RentalFilmEvent(val filmId: TypeId, val customerId: TypeId)