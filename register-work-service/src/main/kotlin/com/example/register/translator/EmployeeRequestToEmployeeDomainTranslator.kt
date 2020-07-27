package com.example.register.translator

import com.example.register.domain.EmployeeDomain
import com.example.register.model.EmployeeRequest
import java.time.LocalDateTime

class EmployeeRequestToEmployeeDomainTranslator {

    fun translate(employeeRequest: EmployeeRequest): EmployeeDomain {
        return EmployeeDomain(documentNumber = employeeRequest.documentNumber, name = employeeRequest.name,
                dateOfBirth = employeeRequest.dateOfBirth, rule = employeeRequest.rule.name,
                jobDescription = employeeRequest.jobDescription, admissionDate = employeeRequest.admissionDate,
                active = true, createdDate = LocalDateTime.now())
    }

}