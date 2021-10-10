package com.github.juliherms.petshop.form

import java.time.LocalDateTime
import javax.validation.constraints.NotNull

data class NewAppointmentForm (
    @field:NotNull
    val userId: Long,
    @field:NotNull
    val petId:Long,
    val annotation: String?,
    @field:NotNull
    val scheduleDate: LocalDateTime
)
