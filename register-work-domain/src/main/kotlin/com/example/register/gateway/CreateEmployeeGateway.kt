package com.example.register.gateway

import com.example.register.domain.EmployeeDomain

interface CreateEmployeeGateway {

    fun execute(employeeDomain: EmployeeDomain)

}