package com.example.videorental.application.customer.useCase

import com.example.videorental.application.customer.events.CreateCustomerEvent
import com.example.videorental.domain.customer.Customer
import com.example.videorental.infrastructure.customer.repository.RepositoryCustomer

class CreateCustomerUseCase(private val repositoryCustomer: RepositoryCustomer) {

    fun execute(createCustomerEvent: CreateCustomerEvent): Customer {
        val customer = Customer(username = createCustomerEvent.username)
        repositoryCustomer.addCustomer(customer)
        return customer
    }
}