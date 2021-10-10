package com.github.juliherms.petshop.model

import javax.persistence.*

@Entity(name = "TB_PET")
data class Pet (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    @ManyToOne
    val tutor: User,
    @ManyToOne
    val breed: Breed
)