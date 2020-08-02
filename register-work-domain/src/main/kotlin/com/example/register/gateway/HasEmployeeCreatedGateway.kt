package com.example.register.gateway

interface HasEmployeeCreatedGateway {

    fun execute(documentNumber: String) : Boolean

}