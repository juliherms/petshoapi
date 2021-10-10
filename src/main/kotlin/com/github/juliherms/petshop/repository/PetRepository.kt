package com.github.juliherms.petshop.repository

import com.github.juliherms.petshop.model.Pet
import com.github.juliherms.petshop.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface PetRepository: JpaRepository<Pet,Long> {

    fun findByTutor(User:User) : List<Pet>
}