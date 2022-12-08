package com.mercadolivro.controller

import com.mercadolivro.controller.reponse.CustomerResponse
import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.extension.toCustomerModel
import com.mercadolivro.extension.toResponse
import com.mercadolivro.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("admin")
class AdminController() {

    @GetMapping("/report")
    fun getAll(): String {
        return "This is a Report. Only Admin can see it"
    }

}