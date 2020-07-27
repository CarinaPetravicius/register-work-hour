package com.example.register.model

enum class EmployeeHttpResponse(val httpStatus: Int, val httpMessage: String) {

    EMPLOYEE_CREATED(201, "created"),
    EMPLOYEE_UPDATED(202, "updated"),
    EMPLOYEE_ALREADY_EXIST(208, "already exist"),
    EMPLOYEE_NOT_FOUND(404, "not found"),
    EMPLOYEE_BAD_REQUEST(400, "bad request"),
    EMPLOYEE_INTERNAL_ERROR(500, "internal error")

}