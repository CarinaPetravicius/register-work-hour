package com.example.register.gateway.database.postgres.translator

import com.example.register.domain.EmployeeDomain
import com.example.register.gateway.database.postgres.model.EmployeeDB

class EmployeeDBToEmployeeDomainTranslator {

    fun translate(employeeDB: EmployeeDB): EmployeeDomain {
        return EmployeeDomain(employeeDB.id, employeeDB.documentNumber, employeeDB.name, employeeDB.dateOfBirth,
                employeeDB.rule, employeeDB.jobDescription, employeeDB.admissionDate, employeeDB.resignationDate,
                employeeDB.active, employeeDB.createdDate, employeeDB.updatedDate)
    }

}