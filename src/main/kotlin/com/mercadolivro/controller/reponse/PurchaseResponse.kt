package com.mercadolivro.controller.reponse

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal

data class PurchaseResponse(
    var id: Int?,
    var nfe: String?,
    var price: BigDecimal,
    @JsonIgnoreProperties(value = ["customer"])
    var books: List<BookResponse>?
)