package com.github.juliherms.petshop.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}