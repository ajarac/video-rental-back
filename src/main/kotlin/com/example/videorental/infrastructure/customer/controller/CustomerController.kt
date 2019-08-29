package com.example.videorental.infrastructure.customer.controller

import com.example.videorental.infrastructure.customer.adapter.CustomerRestAdapter
import com.example.videorental.infrastructure.customer.controller.dto.CustomerResponseDTO
import com.example.videorental.infrastructure.customer.controller.dto.CreateCustomerDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customers")
class CustomerController(@Autowired private val customerRestAdapter: CustomerRestAdapter) {

    @GetMapping()
    fun getAllCustomers(): List<CustomerResponseDTO> {
        return customerRestAdapter.getAllCustomers()
    }

    @PostMapping()
    fun createCustomer(@RequestBody customerDTO: CreateCustomerDTO): ResponseEntity<CustomerResponseDTO> {
        return ResponseEntity(customerRestAdapter.addCustomer(customerDTO), HttpStatus.CREATED)
    }

    @PostMapping("/dummy")
    fun createFilm(@RequestBody filmDTO: CreateCustomerDTO): ResponseEntity<String> {
        return ResponseEntity("Success", HttpStatus.CREATED )
    }

}