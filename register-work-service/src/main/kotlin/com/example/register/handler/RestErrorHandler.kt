package com.example.register.handler

import com.example.register.exception.EmployeeAlreadyExistException
import com.example.register.exception.EmployeeBadRequestException
import com.example.register.exception.EmployeeInternalErrorException
import com.example.register.exception.EmployeeNotFoundException
import com.example.register.model.EmployeeHttpResponse
import com.example.register.model.MessageResponse
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import java.util.function.Consumer
import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class RestErrorHandler {

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleHttpMessageNotReadableException(exception: HttpMessageNotReadableException): MessageResponse? {
        val errorList: ArrayList<String> = ArrayList()
        errorList.add("Bad Request")
        return MessageResponse(EmployeeHttpResponse.EMPLOYEE_BAD_REQUEST.httpStatus,
                EmployeeHttpResponse.EMPLOYEE_BAD_REQUEST.httpMessage, errorList)
    }

    @ExceptionHandler(MissingServletRequestParameterException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMissingServletRequestParameterException(exception: MissingServletRequestParameterException): MessageResponse? {
        val errorList: ArrayList<String> = ArrayList()
        errorList.add(exception.message)
        return MessageResponse(EmployeeHttpResponse.EMPLOYEE_BAD_REQUEST.httpStatus,
                EmployeeHttpResponse.EMPLOYEE_BAD_REQUEST.httpMessage, errorList)
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentTypeMismatchException(exception: MethodArgumentTypeMismatchException): MessageResponse? {
        val errorList: ArrayList<String> = ArrayList()
        errorList.add(exception.message!!)
        return MessageResponse(EmployeeHttpResponse.EMPLOYEE_BAD_REQUEST.httpStatus,
                EmployeeHttpResponse.EMPLOYEE_BAD_REQUEST.httpMessage, errorList)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleConstraintViolationException(exception: ConstraintViolationException): MessageResponse? {
        val errorList: ArrayList<String> = ArrayList()
        exception.constraintViolations.forEach(Consumer { violation: ConstraintViolation<*> -> errorList.add(violation.message) })
        return MessageResponse(EmployeeHttpResponse.EMPLOYEE_BAD_REQUEST.httpStatus,
                EmployeeHttpResponse.EMPLOYEE_BAD_REQUEST.httpMessage, errorList)
    }

    @ExceptionHandler(EmployeeBadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleEmployeeBadRequestException(exception: EmployeeBadRequestException): MessageResponse? {
        val errorList: ArrayList<String> = ArrayList()
        errorList.add(exception.message!!)
        return MessageResponse(EmployeeHttpResponse.EMPLOYEE_BAD_REQUEST.httpStatus,
                EmployeeHttpResponse.EMPLOYEE_BAD_REQUEST.httpMessage, errorList)
    }

    @ExceptionHandler(EmployeeInternalErrorException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleEmployeeInternalErrorException(exception: EmployeeInternalErrorException): MessageResponse? {
        val errorList: ArrayList<String> = ArrayList()
        errorList.add(exception.message!!)
        return MessageResponse(EmployeeHttpResponse.EMPLOYEE_INTERNAL_ERROR.httpStatus,
                EmployeeHttpResponse.EMPLOYEE_INTERNAL_ERROR.httpMessage, errorList)
    }

    @ExceptionHandler(EmployeeAlreadyExistException::class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    fun handleEmployeeAlreadyExistException(exception: EmployeeAlreadyExistException): MessageResponse? {
        val errorList: ArrayList<String> = ArrayList()
        errorList.add(exception.message!!)
        return MessageResponse(EmployeeHttpResponse.EMPLOYEE_ALREADY_EXIST.httpStatus,
                EmployeeHttpResponse.EMPLOYEE_ALREADY_EXIST.httpMessage, errorList)
    }

    @ExceptionHandler(EmployeeNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleEmployeeNotFoundException(exception: EmployeeNotFoundException): MessageResponse? {
        val errorList: ArrayList<String> = ArrayList()
        errorList.add(exception.message!!)
        return MessageResponse(EmployeeHttpResponse.EMPLOYEE_NOT_FOUND.httpStatus,
                EmployeeHttpResponse.EMPLOYEE_NOT_FOUND.httpMessage, errorList)
    }

}