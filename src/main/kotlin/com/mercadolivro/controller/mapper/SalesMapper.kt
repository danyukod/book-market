package com.mercadolivro.controller.mapper

import com.mercadolivro.controller.reponse.SalesResponse
import com.mercadolivro.extension.toResponse
import com.mercadolivro.model.BookModel
import org.springframework.stereotype.Component

@Component
class SalesMapper {

    fun toResponse(models: List<BookModel>): SalesResponse{

        var booksResponse = models.map { it.toResponse() }
        var total = booksResponse.sumOf { it.price }

        return SalesResponse(
            books = booksResponse,
            total = total
        )
    }

}