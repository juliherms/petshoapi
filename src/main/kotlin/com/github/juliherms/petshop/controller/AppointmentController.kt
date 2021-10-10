package com.github.juliherms.petshop.controller

import com.github.juliherms.petshop.dto.AppointmentDTO
import com.github.juliherms.petshop.dto.UserDTO
import com.github.juliherms.petshop.service.AppointmentService
import com.github.juliherms.petshop.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/appointments")
class AppointmentController(
    private val service: AppointmentService
) {


    @GetMapping
    fun list (
        @RequestParam(required = false) name: String?,
        @PageableDefault(size = 5,sort = ["scheduledDate"], direction = Sort.Direction.DESC) pageable: Pageable
    ): Page<AppointmentDTO> {
        return service.list(name,pageable)
    }
}