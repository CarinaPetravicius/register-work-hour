package com.example.register.translator

import com.example.register.domain.EmployeeDomain
import com.example.register.model.EmployeeResponse

class EmployeeDomainToEmployeeResponseTranslator {

    fun translate(employeeDomain: EmployeeDomain): EmployeeResponse {
        return EmployeeResponse(employeeDomain.documentNumber, employeeDomain.name, employeeDomain.dateOfBirth,
                employeeDomain.rule, employeeDomain.jobDescription, employeeDomain.admissionDate)
    }

}