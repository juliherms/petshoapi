package com.github.juliherms.petshop.model


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TB_USER")
data class User (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,
    var name: String,
    var email: String
)
