package com.example.register.gateway

import com.example.register.domain.EmployeeDomain

interface GetActiveEmployeeGateway {

    fun execute(documentNumber: String) : EmployeeDomain

}