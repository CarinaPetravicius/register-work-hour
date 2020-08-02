package com.example.register.gateway.database.postgres.impl

import com.example.register.domain.EmployeeDomain
import com.example.register.exception.EmployeeInternalErrorException
import com.example.register.gateway.UpdateEmployeeGateway
import com.example.register.gateway.database.postgres.repository.EmployeeRepository
import com.example.register.gateway.database.postgres.translator.EmployeeDomainToEmployeeDBTranslator
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Named

@Named
class UpdateEmployeeGatewayImpl(private val employeeRepository: EmployeeRepository) : UpdateEmployeeGateway {

    private val log: Logger = LoggerFactory.getLogger(UpdateEmployeeGatewayImpl::class.java)

    override fun execute(employeeDomain: EmployeeDomain) {
        try {
            employeeRepository.save(EmployeeDomainToEmployeeDBTranslator().translate(employeeDomain))
        } catch (ex: Exception) {
            log.error("Internal error to update the employee", ex)
            throw EmployeeInternalErrorException("Internal error to update the employee: " + ex.message)
        }
    }

}