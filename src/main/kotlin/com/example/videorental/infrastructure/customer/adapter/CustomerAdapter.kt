package com.example.videorental.infrastructure.customer.adapter

import com.example.videorental.infrastructure.customer.controller.dto.CustomerResponseDTO
import com.example.videorental.infrastructure.customer.controller.dto.CreateCustomerDTO

interface CustomerAdapter {
    fun getAllCustomers(): List<CustomerResponseDTO>
    fun addCustomer(createCustomerDTO: CreateCustomerDTO): CustomerResponseDTO
}