package com.mercadolivro.controller.reponse

import java.math.BigDecimal

data class SalesResponse(
    var books: List<BookResponse>,
    var total: BigDecimal
)