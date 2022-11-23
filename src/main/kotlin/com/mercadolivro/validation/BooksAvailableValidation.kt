package com.mercadolivro.validation

import com.mercadolivro.service.BookService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class BooksAvailableValidation(var bookService: BookService): ConstraintValidator<BooksAvaliable, Set<Int>> {

    override fun isValid(values: Set<Int>?, context: ConstraintValidatorContext?): Boolean {
        if(values == null)
            return false

        return bookService.availableBooks(values)
    }


}
