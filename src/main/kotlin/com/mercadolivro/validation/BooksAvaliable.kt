package com.mercadolivro.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [BooksAvailableValidation::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class BooksAvaliable(
    val message: String = "Contem livro não permitido para venda.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
