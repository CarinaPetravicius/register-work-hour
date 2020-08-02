package com.example.register.usecase

import com.example.register.domain.EmployeeDomain
import com.example.register.gateway.GetActiveEmployeeGateway
import javax.inject.Named

@Named
class GetEmployeeUseCase(private val getActiveEmployeeGateway: GetActiveEmployeeGateway) {

    fun execute(documentNumber: String): EmployeeDomain {
        return getActiveEmployeeGateway.execute(documentNumber)
    }

}