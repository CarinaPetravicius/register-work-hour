package com.example.register.domain

import com.example.register.exception.EmployeeBadRequestException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDate
import java.time.LocalDateTime

data class EmployeeDomain(
        val id: Long? = null,
        val documentNumber: Long,
        val name: String,
        val dateOfBirth: LocalDate,
        val rule: String,
        val jobDescription: String,
        val admissionDate: LocalDate,
        val resignationDate: LocalDate? = null,
        val active: Boolean,
        val createdDate: LocalDateTime? = null,
        val updatedDate: LocalDateTime? = null
) {
    private val log: Logger = LoggerFactory.getLogger(EmployeeDomain::class.java)

    fun validateCorrectDateOfBirth() {
        if (dateOfBirth.year >= LocalDate.now().year) {
            log.error("Invalid date of birth")
            throw EmployeeBadRequestException("Invalid date of birth")
        }
    }
}