package com.github.juliherms.petshop.dto

import java.time.LocalDateTime

data class AppointmentDTO (
    val id: Long?,
    val annotation: String?,
    val scheduledDate: LocalDateTime,
    val userName: String,
    val petName: String,
    val breedName: String
 )