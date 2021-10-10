package com.github.juliherms.petshop.mapper

import com.github.juliherms.petshop.form.NewUserForm
import com.github.juliherms.petshop.model.User
import org.springframework.stereotype.Component

@Component
class UserFormMapper : Mapper<NewUserForm,User> {

    override fun map(t: NewUserForm) : User {
        return User(
            name = t.name,
            email =  t.email
        )
    }
}