package com.github.juliherms.petshop.service

import com.github.juliherms.petshop.dto.AppointmentDTO
import com.github.juliherms.petshop.mapper.AppointmentMapper
import com.github.juliherms.petshop.repository.AppointmentRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AppointmentService(
    private val repository: AppointmentRepository,
    private val appointmentMapper:AppointmentMapper
    ) {

    fun list (
        userName: String?,
        pageable: Pageable
    ): Page<AppointmentDTO> {
        val appointments = if (userName == null) {
            repository.findAll(pageable)
        } else {
            repository.findByUserName(userName,pageable)
        }

        return appointments.map { t ->
            appointmentMapper.map(t)
        }
    }

}
