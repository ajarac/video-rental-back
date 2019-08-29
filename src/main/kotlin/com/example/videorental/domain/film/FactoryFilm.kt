package com.example.videorental.domain.film

class FactoryFilm {
    companion object {

        fun createFilm(title: String, typeFilm: TypeFilm): Film {
            return when(typeFilm) {
                TypeFilm.NEW -> NewFilm(title)
                TypeFilm.REGULAR -> RegularFilm(title)
                TypeFilm.OLD -> OldFilm(title)
            }
        }
    }
}