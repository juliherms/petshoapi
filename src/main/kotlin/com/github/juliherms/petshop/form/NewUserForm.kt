package com.github.juliherms.petshop.form

import javax.validation.constraints.NotEmpty

data class NewUserForm (
    @field:NotEmpty(message = "name is not empty")
    val name: String,
    @field:NotEmpty(message = "e-mail is not empty")
    val email: String

)