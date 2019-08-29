package com.example.videorental.application.customer.useCase

import com.example.videorental.domain.customer.Customer
import com.example.videorental.infrastructure.customer.repository.RepositoryCustomer

class GetAllCustomersUseCase(private val repositoryCustomer: RepositoryCustomer) {

    fun execute(): List<Customer> {
        return repositoryCustomer.getAllCustomers()
    }
}