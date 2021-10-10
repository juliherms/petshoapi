package com.github.juliherms.petshop.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "TB_APPOINTMENT")
data class Appointment (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val createDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val user:User,
    @ManyToOne
    val pet:Pet,
    val scheduledDate: LocalDateTime,
    val annotation: String
 )