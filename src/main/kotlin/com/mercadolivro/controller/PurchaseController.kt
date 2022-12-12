package com.mercadolivro.controller

import com.mercadolivro.controller.mapper.PurchaseMapper
import com.mercadolivro.controller.reponse.PurchaseResponse
import com.mercadolivro.controller.request.PostPurchaseRequest
import com.mercadolivro.security.OnlyUser
import com.mercadolivro.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("purchases")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody @Valid request: PostPurchaseRequest) {
        purchaseService.create(purchaseMapper.toModel(request))
    }

    @GetMapping("/customer/{id}")
    @OnlyUser
    @ResponseStatus(HttpStatus.OK)
    fun findAllPurchasesByCustomer(@PathVariable id: Int): List<PurchaseResponse> {
        return purchaseService.findAllByCustomerId(id).map { purchaseMapper.toResponse(it) }
    }


}