package com.example.register.usecase

import com.example.register.domain.EmployeeDomain
import com.example.register.exception.EmployeeAlreadyExistException
import com.example.register.gateway.CreateEmployeeGateway
import com.example.register.gateway.HasEmployeeCreatedGateway
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Named

@Named
class CreateEmployeeUseCase(private val hasEmployeeCreatedGateway: HasEmployeeCreatedGateway,
                            private val createEmployeeGateway: CreateEmployeeGateway) {

    private val log: Logger = LoggerFactory.getLogger(CreateEmployeeUseCase::class.java)

    fun execute(employeeDomain: EmployeeDomain) {
        employeeDomain.validateCorrectDateOfBirth()

        if (hasEmployeeCreatedGateway.execute(employeeDomain.documentNumber)) {
            log.info("Employee document already exist")
            throw EmployeeAlreadyExistException("Employee document already exist")
        }

        createEmployeeGateway.execute(employeeDomain)
    }

}