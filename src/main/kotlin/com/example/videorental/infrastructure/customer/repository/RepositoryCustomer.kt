package com.example.videorental.infrastructure.customer.repository

import com.example.videorental.domain.customer.Customer
import com.example.videorental.domain.shared.TypeId

interface RepositoryCustomer {
    fun addCustomer(customer: Customer)
    fun getAllCustomers(): List<Customer>
    fun getCustomerByCustomerId(customerId: TypeId): Customer
}