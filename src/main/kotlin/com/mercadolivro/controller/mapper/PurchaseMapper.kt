package com.mercadolivro.controller.mapper

import com.mercadolivro.controller.reponse.BookResponse
import com.mercadolivro.controller.reponse.PurchaseResponse
import com.mercadolivro.controller.request.PostPurchaseRequest
import com.mercadolivro.extension.toResponse
import com.mercadolivro.model.PurchaseModel
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CustomerService
import com.mercadolivro.service.PurchaseService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService,
    private val purchaseService: PurchaseService
) {

    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price })
    }

    fun toResponse(model: PurchaseModel): PurchaseResponse{
        var bookResponses = model.books.map { it.toResponse() }

        return PurchaseResponse(
            id = model.id,
            nfe = model.nfe,
            price = model.price,
            books = bookResponses
        )

    }

}