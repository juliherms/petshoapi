package com.github.juliherms.petshop.repository

import com.github.juliherms.petshop.model.Appointment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AppointmentRepository: JpaRepository<Appointment, Long> {

    fun findByUserName(name:String,pageable: Pageable): Page<Appointment>
}