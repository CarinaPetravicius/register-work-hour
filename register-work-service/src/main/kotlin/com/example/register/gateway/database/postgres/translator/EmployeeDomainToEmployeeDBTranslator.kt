package com.example.register.gateway.database.postgres.translator

import com.example.register.domain.EmployeeDomain
import com.example.register.gateway.database.postgres.model.EmployeeDB

class EmployeeDomainToEmployeeDBTranslator {

    fun translate(employeeDomain: EmployeeDomain): EmployeeDB {
        return EmployeeDB(employeeDomain.id, employeeDomain.documentNumber, employeeDomain.name, employeeDomain.dateOfBirth,
                employeeDomain.rule, employeeDomain.jobDescription, employeeDomain.admissionDate, employeeDomain.resignationDate,
                employeeDomain.active, employeeDomain.createdDate, employeeDomain.updatedDate)
    }

}