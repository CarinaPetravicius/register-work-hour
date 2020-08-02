package com.example.register.usecase

import com.example.register.domain.EmployeeDomain
import com.example.register.gateway.GetActiveEmployeeGateway
import com.example.register.gateway.UpdateEmployeeGateway
import javax.inject.Named

@Named
class UpdateEmployeeUseCase(private val getActiveEmployeeGateway: GetActiveEmployeeGateway,
                            private val updateEmployeeGateway: UpdateEmployeeGateway) {

    fun execute(employeeDomain: EmployeeDomain) {
        employeeDomain.validateCorrectDateOfBirth()

        val employeeDomainSaved = getActiveEmployeeGateway.execute(employeeDomain.documentNumber)
        val employeeToBeUpdated = employeeDomainSaved.newEmployeeToBeUpdated(employeeDomain)

        updateEmployeeGateway.execute(employeeToBeUpdated)
    }

}