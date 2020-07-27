package com.example.register.gateway.database.postgres.repository

import com.example.register.gateway.database.postgres.model.EmployeeDB
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EmployeeRepository : JpaRepository<EmployeeDB, String> {

    fun existsByDocumentNumber(documentNumber: Long) : Boolean

    fun findByDocumentNumberAndActive(documentNumber: Long, active: Boolean) : Optional<EmployeeDB>

}