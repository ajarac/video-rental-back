package com.example.videorental.infrastructure.customer.controller.dto

import com.example.videorental.domain.customer.Customer

data class CustomerResponseDTO(val customerId: String, val username: String, val points: Int) {

    companion object {
        fun fromEntity(customer: Customer): CustomerResponseDTO {
            return CustomerResponseDTO(customerId = customer.customerId.toString(), username = customer.username, points = customer.points)
        }
    }
}