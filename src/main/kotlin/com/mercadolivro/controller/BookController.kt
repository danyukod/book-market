package com.mercadolivro.controller

import com.mercadolivro.service.BookService
import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.extension.toBookModel
import com.mercadolivro.service.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    fun create(@RequestBody request: PostBookRequest){
        val customer = customerService.getCustomer(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

}