package com.example.register.gateway.database.postgres.impl

import com.example.register.domain.EmployeeDomain
import com.example.register.exception.EmployeeInternalErrorException
import com.example.register.exception.EmployeeNotFoundException
import com.example.register.gateway.GetActiveEmployeeGateway
import com.example.register.gateway.database.postgres.model.EmployeeDB
import com.example.register.gateway.database.postgres.repository.EmployeeRepository
import com.example.register.gateway.database.postgres.translator.EmployeeDBToEmployeeDomainTranslator
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.Exception
import java.util.*
import javax.inject.Named

@Named
class GetActiveEmployeeGatewayImpl(private val employeeRepository: EmployeeRepository) : GetActiveEmployeeGateway {

    private val log: Logger = LoggerFactory.getLogger(GetActiveEmployeeGatewayImpl::class.java)

    override fun execute(documentNumber: Long): EmployeeDomain {
        val employeeDB: Optional<EmployeeDB>

        try {
            employeeDB = employeeRepository.findByDocumentNumberAndActive(documentNumber, true)
        } catch (ex: Exception) {
            log.error("Internal error to find the active employee", ex)
            throw EmployeeInternalErrorException("Internal error to find the active employee: " + ex.message)
        }

        if (employeeDB.isPresent) return EmployeeDBToEmployeeDomainTranslator().translate(employeeDB.get())
        log.info("Active employee not found")
        throw EmployeeNotFoundException("Active employee not found")
    }

}