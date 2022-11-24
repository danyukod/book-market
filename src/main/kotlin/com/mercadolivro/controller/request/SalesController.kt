package com.mercadolivro.controller.request

import com.mercadolivro.controller.mapper.SalesMapper
import com.mercadolivro.controller.reponse.SalesResponse
import com.mercadolivro.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("sales")
class SalesController(
    private val bookService: BookService,
    private val salesMapper: SalesMapper
) {

    @GetMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findAllSalesByCustomer(@PathVariable id: Int): SalesResponse {
        return salesMapper.toResponse(bookService.findAllSalesBooksByCustomer(id))
    }

}