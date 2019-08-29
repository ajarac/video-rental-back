package com.example.videorental.infrastructure.customer.repository

import com.example.videorental.domain.customer.Customer
import com.example.videorental.domain.shared.TypeId
import com.example.videorental.infrastructure.shared.exception.ItemNotFoundException
import org.springframework.stereotype.Repository

@Repository
class InMemoryRepositoryCustomer : RepositoryCustomer {

    private val listCustomer: HashSet<Customer> = HashSet<Customer>()

    override fun addCustomer(customer: Customer) {
        listCustomer.add(customer)
    }

    override fun getAllCustomers(): List<Customer> {
        return listCustomer.toList()
    }

    override fun getCustomerByCustomerId(customerId: TypeId): Customer {
        return listCustomer.find { it.customerId.equals(customerId) } ?: throw ItemNotFoundException("Customer not found with customerId: $customerId")
    }
}