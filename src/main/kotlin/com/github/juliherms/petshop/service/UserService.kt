package com.github.juliherms.petshop.service

import com.github.juliherms.petshop.dto.UserDTO
import com.github.juliherms.petshop.form.NewUserForm
import com.github.juliherms.petshop.form.UpdateUserForm
import com.github.juliherms.petshop.mapper.UserFormMapper
import com.github.juliherms.petshop.mapper.UserMapper
import com.github.juliherms.petshop.model.User
import com.github.juliherms.petshop.repository.UserRepository
import javassist.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService (
    private val repository: UserRepository,
    private val userMapper: UserMapper,
    private val notFoundMessage: String = "User not found",
    private val userFormMapper: UserFormMapper) {

    fun findById(id:Long): UserDTO {
        val user = repository.findById(id).orElseThrow{NotFoundException(notFoundMessage)}
        return userMapper.map(user)
    }

    fun list(name: String?, pageable: Pageable): Page<UserDTO> {

        val users = if(name == null) {
            repository.findAll(pageable)
        } else {
            repository.findByName(name,pageable)
        }

        return users.map { t -> userMapper.map(t) }
    }

    @Transactional
    fun delete(id:Long) = repository.deleteById(id)

    @Transactional
    fun save(form:NewUserForm): UserDTO {
        val user = userFormMapper.map(form)
        repository.save(user)
        return userMapper.map(user)
    }

    fun update(form: UpdateUserForm) : UserDTO {
        val user = repository.findById(form.id).orElseThrow{NotFoundException(notFoundMessage)}
        user.name = form.name
        user.email =form.email
        return userMapper.map(user)

    }

}