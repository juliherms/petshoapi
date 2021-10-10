package com.github.juliherms.petshop.repository

import com.github.juliherms.petshop.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User,Long> {

    fun findByName(name:String,pageable: Pageable): Page<User>
}