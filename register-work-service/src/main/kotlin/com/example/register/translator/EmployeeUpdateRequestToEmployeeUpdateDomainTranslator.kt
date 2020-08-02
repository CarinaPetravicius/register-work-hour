package com.example.register.translator

import com.example.register.domain.EmployeeDomain
import com.example.register.model.EmployeeUpdateRequest
import java.time.LocalDateTime

class EmployeeUpdateRequestToEmployeeUpdateDomainTranslator {

    fun translate(employeeUpdateRequest: EmployeeUpdateRequest): EmployeeDomain {
        return EmployeeDomain(documentNumber = employeeUpdateRequest.documentNumber, name = employeeUpdateRequest.name,
                dateOfBirth = employeeUpdateRequest.dateOfBirth, rule = employeeUpdateRequest.rule.name,
                jobDescription = employeeUpdateRequest.jobDescription, admissionDate = employeeUpdateRequest.admissionDate,
                resignationDate = employeeUpdateRequest.resignationDate, active = true, updatedDate = LocalDateTime.now())
    }

}