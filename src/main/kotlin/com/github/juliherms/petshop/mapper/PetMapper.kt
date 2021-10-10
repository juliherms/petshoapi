package com.github.juliherms.petshop.mapper

import com.github.juliherms.petshop.dto.PetDTO
import com.github.juliherms.petshop.model.Pet
import org.springframework.stereotype.Component

@Component
class PetMapper : Mapper<Pet,PetDTO> {

    override fun map(t: Pet): PetDTO {
        return PetDTO(
            id = t.id,
            name = t.name,
            breed = t.breed.name,
            onwner = t.tutor.name
        )
    }
}