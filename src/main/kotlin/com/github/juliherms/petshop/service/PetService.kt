package com.github.juliherms.petshop.service

import com.github.juliherms.petshop.model.Pet
import com.github.juliherms.petshop.model.User
import com.github.juliherms.petshop.repository.PetRepository
import com.github.juliherms.petshop.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class PetService (
    private val repository: PetRepository,
    private  val userRepository: UserRepository
        ) {

    fun findByUser(idUser:Long): List<Pet> {

        val user = userRepository.findById(idUser).get()
        return repository.findByTutor(user)

    }
}