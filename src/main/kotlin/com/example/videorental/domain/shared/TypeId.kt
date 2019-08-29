package com.example.videorental.domain.shared

import java.util.*

class TypeId(inputUUID: String?) {

    private var id: String

    init {
        id = generateFilmId(inputUUID).toString()
    }

    override fun toString(): String {
        return id
    }

    fun equals(typeId: TypeId): Boolean {
        return typeId.toString() == id
    }

    private fun generateFilmId(receivedId: String?) =
            if (receivedId != null) UUID.fromString(receivedId)
            else UUID.randomUUID()
}