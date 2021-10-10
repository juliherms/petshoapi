package com.github.juliherms.petshop.controller

import com.github.juliherms.petshop.dto.PetDTO
import com.github.juliherms.petshop.dto.UserDTO
import com.github.juliherms.petshop.model.Pet
import com.github.juliherms.petshop.service.PetService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pets")
class PetController(
    private val service:PetService
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : PetDTO {
        return service.findById(id)

    }
}