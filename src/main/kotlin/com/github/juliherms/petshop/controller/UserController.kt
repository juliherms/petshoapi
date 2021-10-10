package com.github.juliherms.petshop.controller

import com.github.juliherms.petshop.dto.UserDTO
import com.github.juliherms.petshop.form.NewUserForm
import com.github.juliherms.petshop.form.UpdateUserForm
import com.github.juliherms.petshop.model.Pet
import com.github.juliherms.petshop.model.User
import com.github.juliherms.petshop.service.PetService
import com.github.juliherms.petshop.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(
    private val service: UserService,
    private val petService: PetService) {

    /**
     * List all user by page and filter by name
     */
    @GetMapping
    fun list (
        @RequestParam(required = false) name: String?,
        @PageableDefault(size = 5,sort = ["name"], direction = Sort.Direction.DESC) pageable:Pageable
    ): Page<UserDTO> {
        return service.list(name,pageable)
    }

    /**
     * Find user by id
     */
    @GetMapping("/{id}")
    fun findById(@PathVariable id:Long) : UserDTO {
        return service.findById(id)
    }

    /**
     * List all pets from user
     */
    @GetMapping("/{id}/pets")
    fun findPetsByUser(@PathVariable id: Long) : List<Pet> {
        return petService.findByUser(id)

    }

    /**
     * Save user
     */
    @PostMapping
    fun save(
        @RequestBody @Valid form: NewUserForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<UserDTO> {
        val userDTO = service.save(form)
        val uri = uriBuilder.path("/users/${userDTO.id}").build().toUri()
        return  ResponseEntity.created(uri).body(userDTO)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateUserForm) : ResponseEntity<UserDTO> {
        val userDTO = service.update(form)
        return ResponseEntity.ok(userDTO)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id:Long) {
        service.delete(id)
    }
}