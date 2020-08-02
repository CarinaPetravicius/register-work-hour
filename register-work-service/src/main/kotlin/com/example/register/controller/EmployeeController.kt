package com.example.register.controller

import com.example.register.api.EmployeeApi
import com.example.register.model.*
import com.example.register.translator.EmployeeDomainToEmployeeResponseTranslator
import com.example.register.translator.EmployeeRequestToEmployeeDomainTranslator
import com.example.register.translator.EmployeeUpdateRequestToEmployeeUpdateDomainTranslator
import com.example.register.usecase.CreateEmployeeUseCase
import com.example.register.usecase.GetEmployeeUseCase
import com.example.register.usecase.UpdateEmployeeUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
class EmployeeController(private val createEmployeeUseCase: CreateEmployeeUseCase,
                         private val getEmployeeUseCase: GetEmployeeUseCase,
                         private val updateEmployeeUseCase: UpdateEmployeeUseCase) : EmployeeApi {

    private val log: Logger = LoggerFactory.getLogger(EmployeeController::class.java)

    override fun createEmployee(employeeRequest: EmployeeRequest): MessageResponse {
        log.info("Employee API starting to creating the employee: {}", employeeRequest.name)

        val employeeDomain = EmployeeRequestToEmployeeDomainTranslator().translate(employeeRequest)

        createEmployeeUseCase.execute(employeeDomain)

        log.info("Employee API finished to creating the employee")
        return MessageResponse(EmployeeHttpResponse.EMPLOYEE_CREATED.httpStatus, EmployeeHttpResponse.EMPLOYEE_CREATED.httpMessage)
    }

    override fun getEmployee(documentNumber: String): EmployeeResponse {
        log.info("Employee API starting to get the employee")

        val employeeDomain = getEmployeeUseCase.execute(documentNumber)

        log.info("Employee API finished to get the employee")
        return EmployeeDomainToEmployeeResponseTranslator().translate(employeeDomain)
    }

    override fun updateEmployee(employeeUpdateRequest: EmployeeUpdateRequest): MessageResponse {
        log.info("Employee API starting to updating the employee: {}", employeeUpdateRequest.name)

        val employeeDomain = EmployeeUpdateRequestToEmployeeUpdateDomainTranslator().translate(employeeUpdateRequest)

        updateEmployeeUseCase.execute(employeeDomain)

        log.info("Employee API finished to updating the employee")
        return MessageResponse(EmployeeHttpResponse.EMPLOYEE_UPDATED.httpStatus, EmployeeHttpResponse.EMPLOYEE_UPDATED.httpMessage)
    }

}