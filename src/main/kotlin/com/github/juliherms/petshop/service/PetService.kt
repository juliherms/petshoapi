package com.github.juliherms.petshop.service

import com.github.juliherms.petshop.dto.PetDTO
import com.github.juliherms.petshop.dto.UserDTO
import com.github.juliherms.petshop.mapper.PetMapper
import com.github.juliherms.petshop.model.Pet
import com.github.juliherms.petshop.model.User
import com.github.juliherms.petshop.repository.PetRepository
import com.github.juliherms.petshop.repository.UserRepository
import javassist.NotFoundException
import org.springframework.stereotype.Service

@Service
class PetService (
    private val repository: PetRepository,
    private val userRepository: UserRepository,
    private val notFoundMessage: String = "Pet not found",
    private val petMapper:PetMapper
        ) {

    fun findByUser(idUser:Long): List<Pet> {

        val user = userRepository.findById(idUser).get()
        return repository.findByTutor(user)

    }

    fun findById(id:Long): PetDTO{
        val pet = repository.findById(id).orElseThrow{ NotFoundException(notFoundMessage) }
        return petMapper.map(pet)
    }
}