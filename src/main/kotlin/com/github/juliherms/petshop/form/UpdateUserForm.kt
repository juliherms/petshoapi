package com.github.juliherms.petshop.form

import com.sun.istack.NotNull
import javax.validation.constraints.NotEmpty

data class UpdateUserForm (
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    val name: String,
    @field:NotEmpty
    val email: String
)