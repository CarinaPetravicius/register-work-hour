package com.example.register.gateway

import com.example.register.domain.EmployeeDomain

interface UpdateEmployeeGateway {

    fun execute(employeeDomain: EmployeeDomain)

}