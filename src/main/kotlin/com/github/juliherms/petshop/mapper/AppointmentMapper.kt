package com.github.juliherms.petshop.mapper

import com.github.juliherms.petshop.dto.AppointmentDTO
import com.github.juliherms.petshop.model.Appointment
import org.springframework.stereotype.Component

@Component
class AppointmentMapper: Mapper<Appointment, AppointmentDTO> {

    override fun map(t: Appointment): AppointmentDTO {
        return AppointmentDTO(
            id = t.id,
            annotation = t.annotation,
            scheduledDate = t.scheduledDate,
            userName = t.user.name,
            petName = t.pet.name,
            breedName = t.pet.breed.name
        )
    }
}