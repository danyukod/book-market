package com.mercadolivro.repository

import com.mercadolivro.helper.buildCustomer
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@ExtendWith(MockKExtension::class)
class CustomerRepositoryTest {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @BeforeEach
    fun setup() = customerRepository.deleteAll()

    @Test
    fun `should return name containing` () {
        val danilo = customerRepository.save(buildCustomer(name = "Danilo"))
        val daniel = customerRepository.save(buildCustomer(name = "Daniel"))
        val thomas = customerRepository.save(buildCustomer(name = "Thomas"))

        val customers = customerRepository.findByNameContaining("Da")

        assertEquals(listOf(danilo, daniel), customers)

    }
}