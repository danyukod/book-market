package com.mercadolivro.controller.reponse

class PageResponse<T> (
    var itens: List<T>,
    var currentPage: Int,
    var totalItens: Long,
    var totalPages: Int
)