package com.example.videorental.infrastructure.customer.controller.dto

data class CreateCustomerDTO(val username: String) {
    // si quito esto peta
    constructor(): this("") {}
}