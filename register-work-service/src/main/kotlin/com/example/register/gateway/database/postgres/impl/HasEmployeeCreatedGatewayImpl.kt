package com.example.register.gateway.database.postgres.impl

import com.example.register.exception.EmployeeInternalErrorException
import com.example.register.gateway.HasEmployeeCreatedGateway
import com.example.register.gateway.database.postgres.repository.EmployeeRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.Exception
import javax.inject.Named

@Named
class HasEmployeeCreatedGatewayImpl(private val employeeRepository: EmployeeRepository) : HasEmployeeCreatedGateway {

    private val log: Logger = LoggerFactory.getLogger(HasEmployeeCreatedGatewayImpl::class.java)

    override fun execute(documentNumber: Long): Boolean {
        try {
            return employeeRepository.existsByDocumentNumber(documentNumber)
        } catch (ex: Exception) {
            log.error("Internal error to find the employee", ex)
            throw EmployeeInternalErrorException("Internal error to find the employee: " + ex.message)
        }
    }

}