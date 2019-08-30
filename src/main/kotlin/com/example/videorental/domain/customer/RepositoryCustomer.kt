package com.example.videorental.domain.customer

import com.example.videorental.domain.shared.TypeId

interface RepositoryCustomer {
    fun addCustomer(customer: Customer)
    fun getAllCustomers(): List<Customer>
    fun getCustomerByCustomerId(customerId: TypeId): Customer
    fun updateCustomer(customer: Customer)
}