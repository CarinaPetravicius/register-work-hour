package com.example.register.api

import com.example.register.model.EmployeeRequest
import com.example.register.model.EmployeeResponse
import com.example.register.model.MessageResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RequestMapping("/v1/employee")
@Api(tags = ["Employee"])
interface EmployeeApi {

    @ApiOperation(value = "Create an Employee", notes = "Create an Employee")
    @ApiResponses(value = [ApiResponse(code = 201, message = "Created", response = MessageResponse::class),
        ApiResponse(code = 208, message = "Employee already exist", response = MessageResponse::class),
        ApiResponse(code = 400, message = "Bad request", response = MessageResponse::class),
        ApiResponse(code = 500, message = "Internal error to create the employee", response = MessageResponse::class)])
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createEmployee(@Valid @RequestBody employeeRequest: EmployeeRequest): MessageResponse

    @ApiOperation(value = "Get an Employee", notes = "Get an Employee by document")
    @ApiResponses(value = [ApiResponse(code = 200, message = "Ok", response = EmployeeResponse::class),
        ApiResponse(code = 404, message = "Employee not found", response = MessageResponse::class),
        ApiResponse(code = 400, message = "Bad request", response = MessageResponse::class),
        ApiResponse(code = 500, message = "Internal error to get the employee", response = MessageResponse::class)])
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun getEmployee(@Valid @RequestParam("documentNumber")
                    @NotBlank(message = "The document number must be informed") documentNumber: String): EmployeeResponse

}