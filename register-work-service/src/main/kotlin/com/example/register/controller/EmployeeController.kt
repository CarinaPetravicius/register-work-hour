package com.example.register.controller

import com.example.register.api.EmployeeApi
import com.example.register.domain.EmployeeDomain
import com.example.register.model.EmployeeHttpResponse
import com.example.register.model.EmployeeRequest
import com.example.register.model.EmployeeResponse
import com.example.register.model.MessageResponse
import com.example.register.translator.EmployeeDomainToEmployeeResponseTranslator
import com.example.register.translator.EmployeeRequestToEmployeeDomainTranslator
import com.example.register.usecase.CreateEmployeeUseCase
import com.example.register.usecase.GetEmployeeUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
class EmployeeController(private val createEmployeeUseCase: CreateEmployeeUseCase,
                         private val getEmployeeUseCase: GetEmployeeUseCase) : EmployeeApi {

    private val log: Logger = LoggerFactory.getLogger(EmployeeController::class.java)

    override fun createEmployee(employeeRequest: EmployeeRequest): MessageResponse {
        log.info("Employee API starting to creating the employee: {}", employeeRequest.name)

        val employeeDomain: EmployeeDomain = EmployeeRequestToEmployeeDomainTranslator().translate(employeeRequest)

        createEmployeeUseCase.execute(employeeDomain)

        log.info("Employee API finished to creating the employee")
        return MessageResponse(EmployeeHttpResponse.EMPLOYEE_CREATED.httpStatus, EmployeeHttpResponse.EMPLOYEE_CREATED.httpMessage)
    }

    override fun getEmployee(documentNumber: Long): EmployeeResponse {
        log.info("Employee API starting to get the employee")

        val employeeDomain: EmployeeDomain = getEmployeeUseCase.execute(documentNumber)

        log.info("Employee API finished to get the employee")
        return EmployeeDomainToEmployeeResponseTranslator().translate(employeeDomain)
    }

}