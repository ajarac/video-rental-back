package com.example.videorental.infrastructure.customer.adapter

import com.example.videorental.application.customer.events.CreateCustomerEvent
import com.example.videorental.application.customer.useCase.CreateCustomerUseCase
import com.example.videorental.application.customer.useCase.GetAllCustomersUseCase
import com.example.videorental.domain.customer.Customer
import com.example.videorental.infrastructure.customer.controller.dto.CustomerResponseDTO
import com.example.videorental.infrastructure.customer.controller.dto.CreateCustomerDTO
import com.example.videorental.domain.customer.RepositoryCustomer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerRestAdapter(@Autowired private val repositoryCustomer: RepositoryCustomer) : CustomerAdapter {

    private val getAllCustomersUseCase: GetAllCustomersUseCase = GetAllCustomersUseCase(repositoryCustomer)
    private val createCustomerUseCase: CreateCustomerUseCase = CreateCustomerUseCase(repositoryCustomer)

    override fun getAllCustomers(): List<CustomerResponseDTO> {
        val listCustomer: List<Customer> = getAllCustomersUseCase.execute()
        return listCustomer.map { CustomerResponseDTO.fromEntity(it) }
    }

    override fun addCustomer(createCustomerDTO: CreateCustomerDTO): CustomerResponseDTO {
        val createCustomerEvent = CreateCustomerEvent(username = createCustomerDTO.username)
        val customer: Customer = createCustomerUseCase.execute(createCustomerEvent)
        return CustomerResponseDTO.fromEntity(customer)
    }

}