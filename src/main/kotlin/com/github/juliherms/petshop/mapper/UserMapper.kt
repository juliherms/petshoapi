package com.github.juliherms.petshop.mapper

import com.github.juliherms.petshop.dto.UserDTO
import com.github.juliherms.petshop.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper: Mapper<User,UserDTO> {

    override fun map(t: User): UserDTO {
        return UserDTO(
            id = t.id,
            name = t.name,
            email = t.email
        )
    }
}